package com.iup.tp.twitup.ihm;

import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.events.login.ILoginObserver;
import com.iup.tp.twitup.events.twit.ITwitListController;
import com.iup.tp.twitup.events.twit.TwitListController;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class TwitListView extends JPanel {
    final Map<Twit,TwitupTwitView> twitMap;
    final List<ITwitListController> listeners;
    private JButton createTwtit;
    private JButton listUser;
    public TwitListView(Set<Twit> listTwit){
        listeners = new ArrayList<>();
        twitMap = new HashMap<>();
        listTwit.forEach(t -> twitMap.put(t,new TwitupTwitView(t)));
        setLayout(new GridBagLayout());
        addComposant();
    }

    public void addComposant(){
        int index = 0;
        for(TwitupTwitView tw : twitMap.values()){
            add(tw,new GridBagConstraints(0, index, 1, 1, 0, 0, GridBagConstraints.WEST, 1 , new java.awt.Insets(0,0,0,0), 0, 0));
            index++;
        }
        createTwtit = new JButton("add twit");
        createTwtit.addActionListener(e -> doAddTwit());
        add(createTwtit,new GridBagConstraints(0, index, 1, 1, 0, 0, GridBagConstraints.WEST, 1 , new java.awt.Insets(1,0,0,0), 0, 0));
        listUser = new JButton("view all users");
        listUser.addActionListener(e -> doUsers());
        add(listUser,new GridBagConstraints(1, index, 1, 1, 0, 0, GridBagConstraints.EAST, 1 , new java.awt.Insets(1,0,0,0), 0, 0));

    }
    private void doUsers(){ listeners.forEach((c) -> c.notifyViewUsers());}
    private void doAddTwit() {
        listeners.forEach((c) -> c.notifyAddTwit());
    }


    public void addListener(ITwitListController listener) {
        listeners.add(listener);
    }

    public void removeListener(ITwitListController listener) {
        listeners.add(listener);
    }



}
