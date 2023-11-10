/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject4;

/**
 *
 * @author صلاح
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class LoginForm extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;

    public LoginForm() {
        setTitle("Page de Connexion");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 30, 80, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(130, 30, 200, 25);
        add(emailField);

        JLabel passwordLabel = new JLabel("Mot de passe:");
        passwordLabel.setBounds(50, 60, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(130, 60, 200, 25);
        add(passwordField);

        JButton loginButton = new JButton("Se connecter");
        loginButton.setBounds(150, 100, 120, 30);
        add(loginButton);

        JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(50, 130, 300, 25);
        add(messageLabel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                if (email.isEmpty() || password.isEmpty()) {
                    messageLabel.setText("Veuillez remplir tous les champs.");
                } else if (!isValidEmail(email)) {
                    messageLabel.setText("L'email n'est pas au bon format.");
                } else {
                    messageLabel.setText("Connexion réussie !");
                    // Ajoutez ici la logique de connexion
                }
            }
        });
    }

    // Vérification du format de l'email
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginForm loginForm = new LoginForm();
            loginForm.setVisible(true);
        });
    }
}

