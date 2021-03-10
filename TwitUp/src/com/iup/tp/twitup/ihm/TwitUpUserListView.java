package com.iup.tp.twitup.ihm;

import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.events.twit.TwitListController;
import com.iup.tp.twitup.events.user.UserListController;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class TwitUpUserListView extends JPanel {
    final Map<User,TwitUpUserView> useMap;
    final List<UserListController> listeners;

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
    }
}
