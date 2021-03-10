package com.iup.tp.twitup.ihm;

import com.iup.tp.twitup.core.ITwitUpObserver;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.events.user.IProfileObserver;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TwitProfileView extends JPanel {
    protected User user;
    protected JLabel name;
    protected JLabel tag;
    protected JButton retour;
    public final List<IProfileObserver> listeners;

    public TwitProfileView(User user){
        listeners = new ArrayList<>();
        setLayout(new GridBagLayout());
        initComponents(user);
        addComponents();
    }

    public void initComponents(User user){
        name = new JLabel("nom : " +user.getName());
        tag = new JLabel("tag : " +user.getUserTag());
        retour = new JButton("retour");
    }

    public void addComponents(){
        add(name,new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, 1 , new java.awt.Insets(0,0,0,0), 0, 0));
        add(tag,new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, 1 , new java.awt.Insets(0,0,0,0), 0, 0));
        add(retour,new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, 1 , new java.awt.Insets(0,0,0,0), 0, 0));

    }
    public void addListener(IProfileObserver listener) {
        listeners.add(listener);
    }

    public void removeListener(IProfileObserver listener) {
        listeners.add(listener);
    }
}
