/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tp1;

/**
 *
 * @author صلاح
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class Registration extends JFrame {
    JTextField nameField, lastNameField, dobField, emailField;
    JPasswordField passwordField;

    public Registration() {
        setTitle("User Registration");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Nom:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 20, 200, 25);
        panel.add(nameField);

        JLabel lastNameLabel = new JLabel("Prénom:");
        lastNameLabel.setBounds(10, 50, 80, 25);
        panel.add(lastNameLabel);

        lastNameField = new JTextField();
        lastNameField.setBounds(100, 50, 200, 25);
        panel.add(lastNameField);

        JLabel dobLabel = new JLabel("Date de Naissance:");
        dobLabel.setBounds(10, 80, 150, 25);
        panel.add(dobLabel);

        dobField = new JTextField();
        dobField.setBounds(160, 80, 140, 25);
        panel.add(dobField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 110, 80, 25);
        panel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(100, 110, 200, 25);
        panel.add(emailField);

        JLabel passwordLabel = new JLabel("Mot de Passe:");
        passwordLabel.setBounds(10, 140, 100, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 140, 180, 25);
        panel.add(passwordField);

        JButton registerButton = new JButton("Enregistrer");
        registerButton.setBounds(10, 180, 100, 25);
        panel.add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String lastName = lastNameField.getText();
                String dob = dobField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                if (name.isEmpty() || lastName.isEmpty() || dob.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else if (!isValidName(name) || !isValidName(lastName)) {
                    JOptionPane.showMessageDialog(null, "Le format du nom ou prénom n'est pas valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Enregistrement réussi!", "Succès", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    private boolean isValidName(String name) {
        return Pattern.matches("^[\\p{L} .'-]+$", name);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Registration());
    }
}

