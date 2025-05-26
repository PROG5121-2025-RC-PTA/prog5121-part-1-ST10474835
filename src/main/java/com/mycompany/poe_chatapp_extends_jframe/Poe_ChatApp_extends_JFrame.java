/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_chatapp_extends_jframe;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Poe_ChatApp_extends_JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton; 
    private static String currentUsername;
    
    //Replace database with this in-memory store
    private static final Map<String, User> users = new HashMap<>();
    
    //User class for in-memory data
    static class User {
        String name, surname, idNumber, phone, username, password;
        
        User(String name, String surname, String idNumber, String phone, String username, String password){
            this.name = name;
            this.surname = surname;
            this.idNumber = idNumber;
            this.phone = phone;
            this.username = username;
            this.password = password;
        }
    }
    
    public static boolean isValidPhoneNumber(String phone){
        return phone.matches("0\\d{9}");
    }
    
    public static boolean isValidPassword(String password){
        return password.length() >= 8 &&
                password.length() <= 12 &&
                password.matches(".[A-Z].") &&
                password.matches(".\\d.");
    }
    
    public static boolean saveUserToMemory(String name, String surname, String idNumber, String phone, String username, String password){
        if (users.containsKey(username)) {
            JOptionPane.showMessageDialog(null, "Username already exists.");
            return false;
        }
        
        users.put(username, new User(name, surname, idNumber, phone, username, password));
        return true;
    }
    
    public static boolean ChatApp(String username){
        currentUsername = username;
        
        JFrame frame = new JFrame("Chat - " + username);
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        
        JTextField inputField = new JTextField();
        JButton sendButton = new JButton("Send");
        
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        
        frame.add(scrollPane, BorderLayout.CENTER); 
        frame.add(inputPanel, BorderLayout.SOUTH);
        
      
        
        frame.setVisible(true);
        return true;
    }
    
    private void sendMessage() {
        String message = inputField.getText().trim();
        if (!message.isEmpty()) {
            String time = new SimpleDateFormat("HH:mm").format(new Date());
            chatArea.append(currentUsername + " (" + time + "):" + message + "\n");
            inputField.setText("");
            
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    chatArea.append("    ✔✔ Delivered\n");
                    Thread.sleep(1500);
                    chatArea.append("    ✔✔ Read (blue)\n");
                } catch (InterruptedException ignored) {
                }
            }).start();
                
            }
        }
    public static void showRegistrationForm(){
        JTextField nameField = new JTextField();
        JTextField surnameField = new JTextField();
        JTextField idNumberField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        
        JPanel panel = new JPanel(new GridLayout(0,1));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Surname:"));
        panel.add(surnameField);
        panel.add(new JLabel("ID Number:"));
        panel.add(idNumberField);
        panel.add(new JLabel("Phone Number(10 digits, starts with 0):"));
        panel.add(phoneField);
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password(8-12 chars, 1 uppercase, 1 digit):"));
        panel.add(passwordField);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "User Registration", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText().trim();
            String surname = surnameField.getText().trim();
            String idNumber = idNumberField.getText().trim();
            String phone = phoneField.getText().trim();
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());
            
            if(!isValidPhoneNumber(phone)){
                JOptionPane.showMessageDialog(null, "Invalid phone number.");
                return;
            }
            if(!isValidPassword(password)){
                JOptionPane.showMessageDialog(null,"Invalid password.");
                return;
            }
            if(saveUserToMemory(name, surname, idNumber, phone, username, password)){
                JOptionPane.showMessageDialog(null, "Registration successful!");
                SwingUtilities.invokeLater(() -> new Poe_ChatApp(username));
            } else {
                JOptionPane.showMessageDialog(null, "Registration failed");
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Poe_ChatApp_extends_JFrame ::showRegistrationForm);
    }
}


