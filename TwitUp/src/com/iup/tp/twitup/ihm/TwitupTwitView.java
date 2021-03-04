package com.iup.tp.twitup.ihm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;



public class TwitupTwitView extends JPanel {
    protected JLabel name;
    protected JLabel avatar;
    protected JTextArea textArea;
    protected JLabel tag;
    protected GridBagConstraints gbc = new GridBagConstraints();


    public TwitupTwitView(String name, String tag, String text, ImageIcon avatar) {
        setLayout(new GridBagLayout());
        initComposant(name ,tag, text, avatar);

        addComposant();
    }

    public TwitupTwitView() {
        setLayout(new GridBagLayout());
        initComposant("patrick" ,"@patpat", "sdkljfdsklfjdsklfjdkslnf,ze;nbjhzrbjk", new ImageIcon(getClass().getClassLoader().getResource("resources/images/logoIUP_20.jpg")));
        addComposant();
    }

    public void initComposant(String name, String tag, String text, ImageIcon avatar){
        this.name = new JLabel(name);
        this.name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.avatar = new JLabel(avatar);
        this.avatar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.textArea = new JTextArea(text);
        this.textArea.setEditable(false);
        this.textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.tag = new JLabel(tag);
        this.tag.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }
    public void addComposant(){
        //avatar
        gbc.gridx = gbc.gridy = 0;
        gbc.gridheight = 2;
        //gbc.anchor = GridBagConstraints.CENTER;
        //gbc.fill = 1;
        add(avatar,new GridBagConstraints(0, 0, 1, 2, 0, 0, GridBagConstraints.CENTER, 1 , new java.awt.Insets(0,0,0,0), 0, 0));

        //name
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(name,new GridBagConstraints(0, 1, 1, 0, 0, 0, GridBagConstraints.CENTER, 1 , new java.awt.Insets(0,0,0,0), 0, 0));

        //tag

        gbc.gridx = 2;
        gbc.gridy = 1;
        add(tag,new GridBagConstraints(1, 2, 1, 0, 0, 0, GridBagConstraints.CENTER, 1 , new java.awt.Insets(0,0,0,0), 0, 0));

        //text

        gbc.gridwidth = 10;
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(textArea,new GridBagConstraints(0, 5, 1, 2, 0, 0, GridBagConstraints.CENTER, 1 , new java.awt.Insets(0,0,0,0), 0, 0));
    }
}
