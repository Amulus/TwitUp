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

	protected URL logo20 = getClass().getClassLoader().getResource("resources/images/logoIUP_20.jpg");
    protected URL logo50 = getClass().getClassLoader().getResource("resources/images/logoIUP_50.jpg");
    protected URL editIcon = getClass().getClassLoader().getResource("resources/images/editIcon_20.png");
    protected URL exitIcon = getClass().getClassLoader().getResource("resources/images/exitIcon_20.png");


    public TwitupMainView(){
    	initFrame();
       	createMenu();
	}

	public void initFrame(){
		setTitle("TwitUP");
		setSize(400,300);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		try {
			setIconImage(new ImageIcon(logo20).getImage());
			quitItem.setIcon(new ImageIcon(exitIcon));
		} catch (Exception e) {
			e.printStackTrace();
		}
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int choice = chooser.showOpenDialog(this);
		if(choice== JFileChooser.CANCEL_OPTION){
			this.close();
		}
	}

	private void close() {
    	System.exit(0);
	}

	public void createMenu(){
		menuBar.add(fileMen);
		menuBar.add(aboutMen);
		fileMen.add(quitItem);
		setJMenuBar(menuBar);


		aboutMen.addActionListener(
						e -> JOptionPane.showMessageDialog(TwitupMainView.this,"Hello, Welcome to Javatpoint.",null, getDefaultCloseOperation(), new ImageIcon(logo50)));
		quitItem.addActionListener(e->this.close());
	}
}