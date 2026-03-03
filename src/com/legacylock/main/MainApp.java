package com.legacylock.main;

import com.legacylock.manager.VaultManager;
import com.legacylock.model.*;
import com.legacylock.exception.AuthenticationException;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        VaultManager manager = new VaultManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Register Owner");
            System.out.println("2. Register Nominee");
            System.out.println("3. Login");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter username: ");
                        String ownerUser = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String ownerPass = scanner.nextLine();

                        manager.registerUser(new VaultOwner(ownerUser, ownerPass));
                        break;

                    case 2:
                        System.out.print("Enter username: ");
                        String nomineeUser = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String nomineePass = scanner.nextLine();

                        manager.registerUser(new Nominee(nomineeUser, nomineePass));
                        break;

                    case 3:
                        System.out.print("Enter username: ");
                        String loginUser = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String loginPass = scanner.nextLine();
                        User loggedIn = manager.login(loginUser, loginPass);
                        System.out.println("Login successful! Role: " + loggedIn.getRole());

                        if (loggedIn instanceof VaultOwner) {
                                   ownerMenu((VaultOwner) loggedIn, scanner);
                        } else if (loggedIn instanceof Nominee) {
                                   nomineeMenu((Nominee) loggedIn);
                        }

                        break;

                    case 4:
                        System.out.println("Exiting...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (AuthenticationException e) {
                System.out.println("Authentication failed: " + e.getMessage());
            }
        }
    }
    private static void ownerMenu(VaultOwner owner, Scanner scanner) {

        while (true) {
            System.out.println("\n--- Owner Menu ---");
            System.out.println("1. Create Vault");
            System.out.println("2. View My Vaults");
            System.out.println("3. Logout");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter vault name: ");
                    String vaultName = scanner.nextLine();

                    System.out.print("Enter nominee username: ");
                    String nomineeName = scanner.nextLine();

                    Nominee nominee = new Nominee(nomineeName, "default"); // temporary
                    Vault vault = new Vault(vaultName, nominee);
                    owner.addVault(vault);

                    System.out.println("Vault created successfully.");
                    break;

                case 2:
                    for (Vault v : owner.getVaults()) {
                        System.out.println("Vault: " + v.getVaultName());
                    }
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
    private static void nomineeMenu(Nominee nominee) {

        System.out.println("\n--- Nominee Menu ---");
        System.out.println("Welcome Nominee: " + nominee.getUsername());
        System.out.println("Vault access feature will be implemented in Day 4.");
    }
}