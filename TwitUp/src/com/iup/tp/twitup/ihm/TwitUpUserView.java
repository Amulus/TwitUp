package com.iup.tp.twitup.ihm;

import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class TwitUpUserView extends JPanel {
    protected JLabel name;
    protected JLabel avatar;
    protected JTextArea textArea;
    protected JLabel tag;
    protected final GridBagConstraints gbc = new GridBagConstraints();
    protected JButton followUserButton;

    public TwitUpUserView(User u) {
        setLayout(new GridBagLayout());
        initComposant(u.getName(),u.getUserTag(), new ImageIcon(u.getAvatarPath()));
        addComposant();
    }

    private void initComposant(String name, String userTag, ImageIcon avatar) {
            this.name = new JLabel(name);
            this.name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            this.avatar = new JLabel(avatar);
            this.avatar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            this.tag = new JLabel(userTag);
            this.tag.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            this.followUserButton = new JButton("f");
            followUserButton.addActionListener(e -> doFollow());
    }

    private void doFollow() {
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

            //text

            gbc.gridwidth = 10;
            gbc.gridx = 0;
            gbc.gridy = 5;
            add(textArea,new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, 1 , new java.awt.Insets(0,0,0,0), 0, 0));
        }

}
