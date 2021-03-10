package com.iup.tp.twitup.events.register;

import com.iup.tp.twitup.core.Twitup;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.TwitupRegisterView;
import com.iup.tp.twitup.core.ITwitUpObserver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;


public class RegisterController implements IRegisterObserver{
    public final IDatabase mDatabase;
    public final TwitupRegisterView registerView;
    protected Twitup mainController;
    protected final List<ITwitUpObserver> listeners;
    public RegisterController (IDatabase database){
        registerView = new TwitupRegisterView();
        registerView.addListener(this);
        mDatabase = database;
        listeners = new ArrayList<>();
    }


    protected User userNotExists(String username, String password,String tag) {
        for (User user : mDatabase.getUsers()) {
            if (user.getName().equals(username) && user.getUserPassword().equals(password)) {
                return null;
            }
        }
        User user = new User(UUID.randomUUID(), tag, password, username, new HashSet<>(), "");
        mDatabase.addUser(user);
        return user;
    }


    @Override
    public void notifyRegister(String u, String p, String tag) {
        System.out.print("Register...");
        User userInConnexion=userNotExists(u,p,tag);
        if(userInConnexion!= null){
            System.out.println("Done");
            doLogin();
        }
    }

    @Override
    public void notifyCancel() {
        listeners.forEach(ITwitUpObserver::notifyCancel);
    }

    public void doLogin(){
        listeners.forEach(ITwitUpObserver::notifyLogin);
    }

    public void addListener(ITwitUpObserver listener) {
        listeners.add(listener);
    }

    public void removeListener(ITwitUpObserver listener) {
        listeners.add(listener);
    }
}
