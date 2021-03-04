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
		System.out.println(getClass().getClassLoader());
    	initFrame();
       	createMenu();

        //JChooser
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: " +
					chooser.getSelectedFile().getName());
		}
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
		

	}
	public void createMenu(){

		menuBar.add(fileMen);
		menuBar.add(aboutMen);
		fileMen.add(quitItem);
		setJMenuBar(menuBar);


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
	}
}