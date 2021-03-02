package com.iup.tp.twitup.ihm;

import javax.swing.*;
import java.awt.*;

public class TwitupLoginView extends JPanel {
    protected JLabel userLabel = new JLabel("User");
    protected JLabel pwdLabel = new JLabel("Password");
    protected JTextField userField= new JTextField(10);
    protected JTextField pwdField= new JTextField(10);
    protected JButton loginButton= new JButton("Valider");
    protected JButton registerButton= new JButton("S'enregistrer");
    public TwitupLoginView(){
        setLayout(new GridBagLayout());
        userField.setSize(50,50);
        addComponents();
    }

    public void addComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gbc.gridy = 0;
        add(userLabel, gbc);

        gbc.insets = new Insets(0, 15, 0, 0);
        gbc.gridx = 1; gbc.gridy = 0;
        add(userField, gbc);

        gbc.insets = new Insets(0, 15, 0, 0);
        gbc.gridx = 0; gbc.gridy = 1;
        add(pwdLabel, gbc);

        gbc.insets = new Insets(0, 15, 0, 0);
        gbc.gridx = 1; gbc.gridy = 1;
        add(pwdField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;gbc.gridwidth = 1;gbc.gridheight=1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(registerButton,gbc);

        gbc.gridx = 1; gbc.gridy = 2;gbc.gridwidth = 1;gbc.gridheight=1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginButton,gbc);

    }
}
