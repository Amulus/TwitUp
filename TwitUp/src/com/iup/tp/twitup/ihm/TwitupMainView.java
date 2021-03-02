package com.iup.tp.twitup.ihm;

import com.iup.tp.twitup.core.Twitup;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

/**
 * Classe de la vue principale de l'application.
 */
public class TwitupMainView extends JFrame{
    private URL logo20 = getClass().getClassLoader().getResource("images/logoIUP_20.jpg");
    private URL logo50 = getClass().getClassLoader().getResource("images/logoIUP_50.jpg");
    private URL editIcon = getClass().getClassLoader().getResource("images/editIcon_20.png");
    private URL exitIcon = getClass().getClassLoader().getResource("images/exitIcon_20.png");
    private JMenuBar menuBar = new JMenuBar();
    private  JMenu fileMen = new JMenu("Fichier");
    private  JMenu aboutMen = new JMenu("A propos");
    private JMenuItem quitItem = new JMenuItem("Quitter");
    private JPanel primaryPanel = new JPanel();
    private JFileChooser chooser = new JFileChooser();

    public TwitupMainView(){
        setTitle("TwitUP");
        setSize(400,300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        menuBar.add(fileMen);
        menuBar.add(aboutMen);
        setIconImage(new ImageIcon(logo20).getImage());
        System.out.println(exitIcon);
        quitItem.setIcon(new ImageIcon(exitIcon));
        int returnVal = chooser.showOpenDialog(getParent());
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getName());
                    dispose();
        }

        quitItem.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose(); //Destroy the JFrame object
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        fileMen.add(quitItem);
        setJMenuBar(menuBar);

    }


}