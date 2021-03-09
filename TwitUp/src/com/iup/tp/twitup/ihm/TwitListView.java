package com.iup.tp.twitup.ihm;

import com.iup.tp.twitup.datamodel.Twit;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TwitListView extends JPanel {
    Map<Twit,TwitupTwitView> twitMap;
    public TwitListView(Set<Twit> listTwit){
        twitMap = new HashMap<>();
        listTwit.forEach(t -> {
            twitMap.put(t,new TwitupTwitView(t));
        });
        setLayout(new GridBagLayout());
        addComposant();

    }

    public void addComposant(){
        int index = 0;
        for(TwitupTwitView tw : twitMap.values()){
            add(tw,new GridBagConstraints(0, index, 1, 1, 0, 0, GridBagConstraints.CENTER, 1 , new java.awt.Insets(0,0,0,0), 0, 0));
            index++;
        }
    }

}
