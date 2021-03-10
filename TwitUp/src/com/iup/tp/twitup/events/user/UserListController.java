package com.iup.tp.twitup.events.user;

import com.iup.tp.twitup.core.ITwitUpObserver;
import com.iup.tp.twitup.core.Twitup;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.events.register.IRegisterObserver;
import com.iup.tp.twitup.ihm.TwitListView;
import com.iup.tp.twitup.ihm.TwitUpUserListView;
import com.iup.tp.twitup.ihm.TwitUpUserView;
import com.iup.tp.twitup.ihm.TwitupMainView;

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
        // userView.addListener(this);
    }

    @Override
    public void notifyCancel() {
        listeners.forEach((c) -> c.notifyCancelCreate());
    }


    @Override
    public void notifyFollow(String tag) {
        User user =Twitup.userLogged;
        if(! user.getFollows().contains(tag)){
            user.addFollowing(tag);
            System.out.println("Ajout d'un nouveau follow");
        }
    }

    public void addListener(ITwitUpObserver listener) {
        listeners.add(listener);
    }

    public void removeListener(ITwitUpObserver listener) {
        listeners.add(listener);
    }

}
