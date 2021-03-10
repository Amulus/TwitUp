package com.iup.tp.twitup.ihm;

import com.iup.tp.twitup.events.login.ILoginObserver;
import com.iup.tp.twitup.events.twit.ITwitCreateObserver;

import javax.swing.*;
import java.util.List;

public class TwitCreateView extends JPanel {
    protected JLabel description;
    protected JTextArea twitArea;
    protected List<ITwitCreateObserver> listeners;
    protected JButton sendButton;

    public TwitCreateView(){
        initComponents();
        addComponents();
    }
    public void initComponents(){

    }
    public void addComponents(){

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
