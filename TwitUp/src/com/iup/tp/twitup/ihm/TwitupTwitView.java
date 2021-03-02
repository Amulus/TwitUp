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


    public TwitupTwitView(String name, String tag, String text, ImageIcon avatar) {
        initComposant(name ,tag, text, avatar);

        addComposant();
    }

    public TwitupTwitView() {
        initComposant("" ,"", "", new ImageIcon());

        addComposant();
    }

    public void initComposant(String name, String tag, String text, ImageIcon avatar){
        this.name = new JLabel(name);
        this.avatar = new JLabel(avatar);
        this.textArea = new JTextArea(text);
        this.textArea.setEditable(false);
        this.tag = new JLabel(tag);

    }
    public void addComposant(){
        add(name);
        add(textArea);
        add(tag);
        add(avatar);
    }
}
