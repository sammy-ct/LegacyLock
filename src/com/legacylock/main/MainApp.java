package com.legacylock.main;

import java.util.Scanner;
import java.time.LocalDateTime;

import com.legacylock.model.*;
import com.legacylock.manager.VaultManager;
import com.legacylock.strategy.TimeBasedCondition;

public class MainApp {

    private static Scanner scanner = new Scanner(System.in);
    private static VaultManager vaultManager = new VaultManager();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n==== LEGACY LOCK SYSTEM ====");
            System.out.println("1. Create Vault");
            System.out.println("2. View Vaults");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createVault();
                    break;

                case 2:
                    viewVaults();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void createVault() {

        System.out.print("Enter Vault Name: ");
        String vaultName = scanner.nextLine();

        System.out.print("Enter Nominee Name: ");
        String nomineeName = scanner.nextLine();

        System.out.print("Enter Nominee Email: ");
        String nomineeEmail = scanner.nextLine();

        Nominee nominee = new Nominee(nomineeName, nomineeEmail);

        //  Strategy Pattern
        TimeBasedCondition condition = new TimeBasedCondition(LocalDateTime.now().plusMinutes(1));

        Vault vault = new Vault(vaultName, nominee, condition);

        vaultManager.addVault(vault);

        System.out.println("Vault created successfully with Time-Based Release (1 minute).");
    }

    private static void viewVaults() {

        for (Vault vault : vaultManager.getVaults()) {
            System.out.println("\nVault Name: " + vault.getVaultName());
            System.out.println("Nominee: " + vault.getNominee().getName());

            if (vault.checkRelease()) {
                System.out.println("Status: READY FOR RELEASE");
            } else {
                System.out.println("Status: Locked");
            }
        }
    }
}