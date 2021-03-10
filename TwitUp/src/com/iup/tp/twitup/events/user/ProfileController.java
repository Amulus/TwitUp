package com.iup.tp.twitup.events.user;

import com.iup.tp.twitup.core.ITwitUpObserver;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.TwitProfileView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProfileController implements IProfileObserver{

    public TwitProfileView twitUpProfileView;
    protected final List<ITwitUpObserver> listeners;

    public ProfileController(User userLogged){
        listeners = new ArrayList<>();
        twitUpProfileView = new TwitProfileView(userLogged);
        twitUpProfileView.addListener(this);
    }

    public void addListener(ITwitUpObserver listener) {
        listeners.add(listener);
    }

    public void removeListener(ITwitUpObserver listener) {
        listeners.add(listener);
    }

    @Override
    public void notifyBack() {
        listeners.forEach( ITwitUpObserver::notifySendTwit);
    }
}
