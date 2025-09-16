/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javapractical7_whileloop;

import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 */
public class JavaPractical7_Whileloop {

    /**
     * @param args 
     */
    public static void main(String[] args) {
        
    }public static void main(String[]args, int attempts){
        Scanner scanner = new Scanner(System.in);
        
        String registeredUsername = "";
        String registeredPassword = "";
        
        System.out.println("Welcome to the registrationpage");
        
        //Registration
        System.out.println("Register a username: ");
        registeredUsername = scanner.nextLine();
        
        System.out.println("Register a password: ");
        registeredPassword = scanner.nextLine();
        
        System.out.println("\nRegistration successful!");
        System.out.println("Please log in to continue");
        
        int maxAttempts = 3;
        boolean isLoggedIn = false;
        
        while (attempts < maxAttempts && !isLoggedIn){
            System.out.println("\nEnter username: ");
            String username = scanner.nextLine();
            
            System.out.println("Enter password: ");
            String password = scanner.nextLine();
            
            if (username.equals(registeredUsername)&& password.equals(registeredPassword)){
                System.out.println("Login successful! Welcome, " + username + "!");
                isLoggedIn = true;
            }else{
                attempts++;
                int remaining = maxAttempts - attempts;
                System.out.println("Incorrect username or password. Attempts remaining: " + remaining);
            }
        }
        if (!isLoggedIn){
            System.out.println("Too many failed attempts. Account locked.");
        }
        
        scanner.close();
    }
}
