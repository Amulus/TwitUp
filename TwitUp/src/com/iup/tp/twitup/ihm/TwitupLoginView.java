package com.iup.tp.twitup.ihm;

import javax.swing.*;
import java.awt.*;

public class TwitupLoginView extends JPanel {
    protected JLabel userLabel = new JLabel("User");
    protected JLabel pwdLabel = new JLabel("Password");
    protected JTextField userField= new JTextField(10);
    protected JTextField pwdField= new JTextField(10);
    protected JButton loginButton= new JButton("Valider");

    public TwitupLoginView(){
        setLayout(new GridBagLayout());
        userField.setSize(50,50);
        addComponents();
    }

    public void addComponents() {
        add(userLabel);
        add(userField);
        add(pwdLabel);
        add(pwdField);
        add(loginButton);
    }
}
