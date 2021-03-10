package com.iup.tp.twitup.events.user;

import com.iup.tp.twitup.core.ITwitUpObserver;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.events.register.IRegisterObserver;
import com.iup.tp.twitup.ihm.TwitListView;
import com.iup.tp.twitup.ihm.TwitUpUserListView;

import java.util.ArrayList;
import java.util.List;

public class UserListController implements IUserListController{

    protected IDatabase mDatabase;
    protected List<ITwitUpObserver> listeners;
    public TwitUpUserListView twitUpUserListView;
    public UserListController(IDatabase database){
        mDatabase = database;
        listeners = new ArrayList<>();
        twitUpUserListView = new TwitUpUserListView(mDatabase.getUsers());
        twitUpUserListView.addListener(this);

    }

    @Override
    public void notifyCancel() {
        listeners.forEach((c) -> c.notifyCancelCreate());
    }

    public void addListener(ITwitUpObserver listener) {
        listeners.add(listener);
    }

    public void removeListener(ITwitUpObserver listener) {
        listeners.add(listener);
    }

}
