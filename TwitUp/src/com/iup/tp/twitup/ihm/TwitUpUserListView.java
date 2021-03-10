package com.iup.tp.twitup.ihm;

import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.events.register.IRegisterObserver;
import com.iup.tp.twitup.events.twit.ITwitListController;
import com.iup.tp.twitup.events.twit.TwitListController;
import com.iup.tp.twitup.events.user.IUserListController;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class TwitUpUserListView extends JPanel {
    final Map<User,TwitUpUserView> useMap;
    final List<IUserListController> listeners;
    protected JButton returnTwitButton;
    public TwitUpUserListView(Set<User> listUser){
        listeners = new ArrayList<>();
        useMap = new HashMap<>();
        listUser.forEach(u -> useMap.put(u,new TwitUpUserView(u)));
        setLayout(new GridBagLayout());
        addComposant();
    }

    public void addComposant(){
        int index = 0;
        for(TwitUpUserView us : useMap.values()){
            add(us,new GridBagConstraints(0, index, 1, 1, 0, 0, GridBagConstraints.WEST, 1 , new java.awt.Insets(0,0,0,0), 0, 0));
            index++;
        }
        returnTwitButton = new JButton("Return");
        returnTwitButton.addActionListener(e -> doCancel());
        add(returnTwitButton, new GridBagConstraints(0,index+1,1,1,0,0,GridBagConstraints.CENTER, 1,new java.awt.Insets(0,0,0,0),0,0));

    }

    public void doCancel() {
        listeners.forEach(IUserListController::notifyCancel);
    }
    public void addListener(IUserListController listener) {
        listeners.add(listener);
    }

    public void removeListener(IUserListController listener) {
        listeners.add(listener);
    }
}
