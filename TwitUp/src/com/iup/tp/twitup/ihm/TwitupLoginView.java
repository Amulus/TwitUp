package com.iup.tp.twitup.ihm;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import com.iup.tp.twitup.events.login.ILoginObserver;

public class TwitupLoginView extends JPanel {
    protected final JLabel userLabel = new JLabel("User");
    protected final JLabel pwdLabel = new JLabel("Password");
    protected final JTextField userField= new JTextField(10);
    protected final JTextField pwdField= new JTextField(10);
    protected final JButton loginButton= new JButton("Valider");
    protected final JButton registerButton= new JButton("S'enregistrer");
    protected final List<ILoginObserver> listeners;
    public TwitupLoginView(){
        listeners = new ArrayList<>();
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

        loginButton.addActionListener(e -> doLogin(userField.getText(),pwdField.getText()));
        registerButton.addActionListener(e -> doRegsiter());
    }
    protected void doRegsiter() {
        listeners.forEach(ILoginObserver::notifyRegister);
    }

    public void doLogin(String username, String password) {
        listeners.forEach(c ->c.notifyLogin(username,password));
    }


    public void addListener(ILoginObserver listener) {
        listeners.add(listener);
    }

    public void removeListener(ILoginObserver listener) {
        listeners.add(listener);
    }

}
