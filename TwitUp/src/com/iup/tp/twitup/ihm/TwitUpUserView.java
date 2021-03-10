package com.iup.tp.twitup.ihm;

import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.events.user.IUserListController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TwitUpUserView extends JPanel {
    protected List<IUserListController> listeners;
    protected JLabel name;
    protected JLabel avatar;
    protected JLabel tag;
    protected User user;
    protected final GridBagConstraints gbc = new GridBagConstraints();
    protected JButton followUserButton;

    public TwitUpUserView(User u) {
        this.user= u;
        listeners = new ArrayList<>();
        setLayout(new GridBagLayout());
        initComposant(u.getName(),u.getUserTag(), new ImageIcon(u.getAvatarPath()));
        addComposant();
    }

    private void initComposant(String name, String userTag, ImageIcon avatar) {
            this.name = new JLabel(name);
            this.name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            this.avatar = new JLabel(avatar);
            this.avatar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            this.tag = new JLabel("@"+userTag);
            this.tag.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            this.followUserButton = new JButton("Follow the user");
            followUserButton.addActionListener(e -> doFollow());
    }

    private void doFollow() {
        listeners.forEach((c)->c.notifyFollow(this.tag.getText()));
    }

    public void addComposant(){
            //avatar
            gbc.gridx = gbc.gridy = 0;
            gbc.gridheight = 2;
            add(avatar,new GridBagConstraints(0, 0, 1, 2, 0, 0, GridBagConstraints.CENTER, 1 , new java.awt.Insets(0,0,0,0), 0, 0));

            //name
            gbc.gridx = 1;
            gbc.gridy = 0;
            add(name,new GridBagConstraints(1, 2, 1, 0, 0, 0, GridBagConstraints.CENTER, 1 , new java.awt.Insets(0,0,0,0), 0, 0));

            //tag

            gbc.gridx = 2;
            gbc.gridy = 1;
            add(tag,new GridBagConstraints(2, 2, 1, 0, 0, 0, GridBagConstraints.CENTER, 1 , new java.awt.Insets(0,0,0,0), 0, 0));

            //button
            gbc.gridx = 2;
            gbc.gridy = 1;
            add(followUserButton,new GridBagConstraints(3, 2, 1, 0, 0, 0, GridBagConstraints.CENTER, 1 , new java.awt.Insets(0,0,0,0), 0, 0));

    }
    public void addListener(IUserListController listener) {
        listeners.add(listener);
    }

    public void removeListener(IUserListController listener) {
        listeners.add(listener);
    }


}
