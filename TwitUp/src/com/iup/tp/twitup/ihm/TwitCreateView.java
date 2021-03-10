package com.iup.tp.twitup.ihm;

import com.iup.tp.twitup.events.login.ILoginObserver;
import com.iup.tp.twitup.events.twit.ITwitCreateObserver;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TwitCreateView extends JPanel {
    protected JLabel description;
    protected JTextArea twitArea;
    protected List<ITwitCreateObserver> listeners;
    protected JButton sendButton;
    protected JButton cancelButton;

    public TwitCreateView(){
        initComponents();
        addComponents();
        setLayout(new GridBagLayout());
    }
    public void initComponents(){
        description = new JLabel("Raconter votre vie : ");
        twitArea = new JTextArea(3, 16);
        sendButton = new JButton("Envoyer");
        cancelButton = new JButton("Cancel");
        sendButton.addActionListener(e -> doSend());
        cancelButton.addActionListener(e -> doCancel());
    }
    public void addComponents(){
        add(description,new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.WEST, 1 , new java.awt.Insets(0,0,0,0), 0, 0));
        add(twitArea,new GridBagConstraints(0, 0, 3, 3, 0, 0, GridBagConstraints.WEST, 1 , new java.awt.Insets(0,0,0,0), 0, 0));
        add(sendButton,new GridBagConstraints(4, 0, 1, 1, 0, 0, GridBagConstraints.WEST, 1 , new java.awt.Insets(0,0,0,0), 0, 0));

    }

    public void doCancel(){
        listeners.forEach(listener -> listener.notifyCancel());
    }

    public void doSend(){
        listeners.forEach( listener -> listener.notifySend(twitArea.getText()));
    }

    public void addListener(ITwitCreateObserver listener) {
        listeners.add(listener);
    }

    public void removeListener(ITwitCreateObserver listener) {
        listeners.add(listener);
    }

}
