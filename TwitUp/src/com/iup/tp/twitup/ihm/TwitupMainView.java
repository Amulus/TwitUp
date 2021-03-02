package com.iup.tp.twitup.ihm;

import com.iup.tp.twitup.core.Twitup;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

/**
 * Classe de la vue principale de l'application.
 */
public class TwitupMainView extends JFrame{
    protected JMenuBar menuBar = new JMenuBar();
    protected  JMenu fileMen = new JMenu("Fichier");
    protected  JMenu aboutMen = new JMenu("?");
    protected JMenuItem quitItem = new JMenuItem("Quitter");
	protected	JFileChooser chooser = new JFileChooser();

	protected URL logo20 = getClass().getClassLoader().getResource("images/logoIUP_20.jpg");
    protected URL logo50 = getClass().getClassLoader().getResource("images/logoIUP_50.jpg");
    protected URL editIcon = getClass().getClassLoader().getResource("images/editIcon_20.png");
    protected URL exitIcon = getClass().getClassLoader().getResource("images/exitIcon_20.png");

    public TwitupMainView(){
        setTitle("TwitUP");
        setSize(400,300);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        menuBar.add(fileMen);
        menuBar.add(aboutMen);

		getContentPane().setLayout(new BorderLayout());
        setIconImage(new ImageIcon(logo20).getImage());
        quitItem.setIcon(new ImageIcon(exitIcon));
        aboutMen.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(TwitupMainView.this,"Hello, Welcome to Javatpoint.",null, getDefaultCloseOperation(), new ImageIcon(logo50));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}



        });
        quitItem.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
        });
        fileMen.add(quitItem);
        setJMenuBar(menuBar);

        //JChooser
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: " +
					chooser.getSelectedFile().getName());
		}
    }


}