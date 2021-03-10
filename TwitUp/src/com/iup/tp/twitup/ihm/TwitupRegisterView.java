package com.iup.tp.twitup.ihm;

import com.iup.tp.twitup.events.register.IRegisterObserver;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TwitupRegisterView extends JPanel{

    protected final List<IRegisterObserver> listeners;

    protected JLabel userLabel;
    protected JLabel pwdLabel;
    protected JLabel tagLabel;
    protected JTextField userField;
    protected JPasswordField pwdField;
    protected JTextField tagField;
    protected JButton registerButton;
    protected JButton cancelButton;

    public TwitupRegisterView(){
        listeners = new ArrayList<>();
        setLayout(new GridBagLayout());
        initComposant();
        addComposant();
    }

    public void initComposant(){
        userLabel = new JLabel("User");
        pwdLabel = new JLabel("Password");
        tagLabel = new JLabel("Tag");
        userField= new JTextField(10);
        pwdField= new JPasswordField(10);
        tagField= new JTextField(10);
        registerButton = new JButton("Register");
        cancelButton = new JButton("Cancel");
    }

    public void addComposant(){
        add(userLabel,new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, 1 , new java.awt.Insets(0,0,0,0), 0, 0));
        add(userField,new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, 1 , new java.awt.Insets(0,0,0,0), 0, 0));

        add(pwdLabel,new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, 1 , new java.awt.Insets(0,0,0,0), 0, 0));
        add(pwdField,new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, 1 , new java.awt.Insets(0,0,0,0), 0, 0));

        add(tagLabel,new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, 1 , new java.awt.Insets(0,0,0,0), 0, 0));
        add(tagField,new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, 1 , new java.awt.Insets(0,0,0,0), 0, 0));

        add(registerButton,new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, 1 , new java.awt.Insets(0,0,0,0), 0, 0));
        add(cancelButton,new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, 1 , new java.awt.Insets(0,0,0,0), 0, 0));

        registerButton.addActionListener(e -> doRegister(userField.getText(), tagField.getText(), pwdField.getText()));
        cancelButton.addActionListener(e -> doCancel());
    }

    public void doRegister(String username, String tag, String password){
        listeners.forEach(c ->c.notifyRegister(username,password,tag));
    }
    public void doCancel() {
        listeners.forEach(IRegisterObserver::notifyCancel);
    }
        public void addListener(IRegisterObserver listener) {
        listeners.add(listener);
    }

    public void removeListener(IRegisterObserver listener) {
        listeners.add(listener);
    }
}
