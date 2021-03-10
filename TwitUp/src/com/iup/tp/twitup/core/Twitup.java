package com.iup.tp.twitup.core;

import java.io.File;
import java.util.HashSet;
import java.util.UUID;

import com.iup.tp.databaseobserver.AppDatabaseObserver;
import com.iup.tp.twitup.datamodel.Database;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.events.file.IWatchableDirectory;
import com.iup.tp.twitup.events.file.WatchableDirectory;
import com.iup.tp.twitup.events.register.RegisterController;
import com.iup.tp.twitup.events.twit.TwitListController;
import com.iup.tp.twitup.ihm.*;

import com.iup.tp.twitup.events.login.LoginController;

import javax.swing.*;

/**
 * Classe principale l'application.
 * 
 * @author S.Lucas
 */
public class Twitup implements ITwitUpObserver{
	/**
	 * Base de données.
	 */
	protected Database mDatabase;

	/**
	 * Gestionnaire des entités contenu de la base de données.
	 */
	protected EntityManager mEntityManager;

	/**
	 * Vue principale de l'application.
	 */
	protected TwitupMainView mMainView;

	/**
	 * Classe de surveillance de répertoire
	 */
	protected IWatchableDirectory mWatchableDirectory;

	/**
	 * Répertoire d'échange de l'application.
	 */
	protected String mExchangeDirectoryPath;

	/**
	 * Idnique si le mode bouchoné est activé.
	 */



	protected boolean mIsMockEnabled = false;

	/**
	 * Nom de la classe de l'UI.
	 */
	protected String mUiClassName;

	protected  LoginController loginController;
	protected  RegisterController registerController;
	protected  TwitListController twitListController;
	private AppDatabaseObserver mConsole;



	public static User userLogged;
	/**
	 * Constructeur.
	 */
	public Twitup() {
		// Init du look and feel de l'application
		this.initLookAndFeel();

		// Initialisation de la base de données
		this.initDatabase();
		
		this.initObserver();

		if (this.mIsMockEnabled) {
			// Initialisation du bouchon de travail
			this.initMock();
		}

		// Initialisation de l'IHM
		this.initGui();

		// Initialisation du répertoire d'échange
		this.initDirectory();

		loadLogin();

	}

	/**
	 * Initialisation du look and feel de l'application.
	 */
	protected void initLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getLookAndFeel());
		} catch( Exception ex ) {
			System.err.println( "Failed to initialize LaF" );
		}
	}

	/**
	 * Initialisation de l'interface graphique.
	 */
	protected void initGui() {

		this.mMainView = new TwitupMainView();
		mMainView.addListener(this);

	}

	/**
	 * Initialisation du répertoire d'échange (depuis la conf ou depuis un file
	 * chooser). <br/>
	 * <b>Le chemin doit obligatoirement avoir été saisi et être valide avant de
	 * pouvoir utiliser l'application</b>
	 */
	protected void initDirectory() {
		//mMainView;
	}

	/**
	 * Indique si le fichier donné est valide pour servire de répertoire
	 * d'échange
	 * 
	 * @param directory
	 *            , Répertoire à tester.
	 */
	protected boolean isValideExchangeDirectory(File directory) {
		// Valide si répertoire disponible en lecture et écriture
		return directory != null && directory.exists() && directory.isDirectory() && directory.canRead()
				&& directory.canWrite();
	}

	/**
	 * Initialisation du mode bouchoné de l'application
	 */
	protected void initMock() {
		TwitupMock mock = new TwitupMock(this.mDatabase, this.mEntityManager);
		mock.showGUI();
	}
	
	
	/**
	 * Initialisation de la base de données
	 */
	protected void initDatabase() {
		mDatabase = new Database();
		mEntityManager = new EntityManager(mDatabase);
		User ere= new User(UUID.randomUUID(), "test", "--", "test", new HashSet<String>(), "");
		Twit twit= new Twit(ere, "Le signe des 5");
		Twit twit2= new Twit(ere, "La belle vie #5G");
		mDatabase.addUser(ere);
		mDatabase.addTwit(twit);
		mDatabase.addTwit(twit2);
	}
	
	/**
	 * Initialisation de l'observer de la base de données
	 */
	
	protected void initObserver() {
			mConsole = new AppDatabaseObserver();
			mDatabase.addObserver(mConsole);
		}
	/**
	 * Initialisation du répertoire d'échange.
	 * 
	 * @param directoryPath
	 */
	public void initDirectory(String directoryPath) {
		mExchangeDirectoryPath = directoryPath;
		mWatchableDirectory = new WatchableDirectory(directoryPath);
		mEntityManager.setExchangeDirectory(directoryPath);

		mWatchableDirectory.initWatching();
		mWatchableDirectory.addObserver(mEntityManager);
	}


	protected  void loadLogin(){
		loginController = new LoginController(mDatabase);
		loginController.addListener(this);
		mMainView.getContentPane().removeAll();
		mMainView.getContentPane().add(loginController.loginView);
		mMainView.repaint();
		mMainView.revalidate();
	}

	protected  void loadRegister(){
		registerController = new RegisterController(mDatabase);
		registerController.addListener(this);
		mMainView.getContentPane().removeAll();
		mMainView.getContentPane().add(registerController.registerView);
		mMainView.repaint();
		mMainView.revalidate();
		// loginController.removeListener(this);
	}

	protected  void loadTwitList(){
		twitListController = new TwitListController(mDatabase);
		twitListController.addListener(this);
		mMainView.getContentPane().removeAll();
		mMainView.getContentPane().add(twitListController.twitListView);
		mMainView.repaint();
		mMainView.revalidate();
	}

	public void show() {
		this.mMainView.setVisible(true);
	}

	@Override
	public void notifyRegister() {
		System.out.println("Changement de page à effectué");
		loadRegister();
	}


	@Override
	public void notifyCancel() {
		System.out.println("Changement de page à effectué");
		loadLogin();
	}

	@Override
	public void notifySendTwit() {
		System.out.println("Changement de page à effectué");
		loadTwitList();
	}

	@Override
	public void notifyLogOut() {
		userLogged = null;
		mMainView.onLogout();
		loadLogin();
	}

	@Override
	public void notifyLogin() {
		System.out.println("Changement de page à effectué");
		mMainView.onLogin();
		loadTwitList();
	}

}
