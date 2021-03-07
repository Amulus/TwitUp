package com.iup.tp.twitup.events.login;

import java.util.*;

import com.iup.tp.twitup.datamodel.Database;
import com.iup.tp.twitup.core.Twitup;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.TwitupLoginView;
import com.iup.tp.twitup.ihm.TwitupTwitView;

import javax.swing.*;

public class LoginController implements ILoginObserver {
    public Database mDatabase;
    public TwitupLoginView loginView;

    public LoginController(Database database) {
        mDatabase = database;
        loginView= new TwitupLoginView();
        loginView.addListener(this);
    }

    protected User userExists(String username, String password) {
        for (User user : mDatabase.getUsers()) {
            if (user.getName().equals(username) && user.getUserPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void doLog(User user) {
            Twitup.userLogged = user;
    }

    @Override
    public void notifyLogin(String usr, String pwd) {
        System.out.print("Connection...");
        User userInConnexion=userExists(usr,pwd);
        if(userInConnexion!= null){
            doLog(userInConnexion);
            System.out.println("Réussi");
            notifyTwit();
        }
    }


    @Override
    public void notifyRegister() {}

    @Override
    public void notifyTwit() {
    }


}
