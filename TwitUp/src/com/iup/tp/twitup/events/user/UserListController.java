package com.iup.tp.twitup.events.user;

import com.iup.tp.twitup.core.ITwitUpObserver;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.TwitListView;
import com.iup.tp.twitup.ihm.TwitUpUserListView;

import java.util.ArrayList;
import java.util.List;

public class UserListController implements IUserListController{

    protected User userLogged;
    protected IDatabase mDatabase;
    protected List<ITwitUpObserver> listeners;
    public TwitUpUserListView twitUpUserListView;
    public UserListController(IDatabase database){
        mDatabase = database;
        twitUpUserListView = new TwitUpUserListView(mDatabase.getUsers());
        listeners = new ArrayList<>();

    }

    @Override
    public void notifyUserList() {
        listeners.forEach((c)-> c.notifyUsers());
    }
    public void addListener(ITwitUpObserver listener) {
        listeners.add(listener);
    }

    public void removeListener(ITwitUpObserver listener) {
        listeners.add(listener);
    }

}
