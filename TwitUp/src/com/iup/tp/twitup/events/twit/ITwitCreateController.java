package com.iup.tp.twitup.events.twit;

import com.iup.tp.twitup.core.ITwitUpObserver;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.TwitCreateView;
import com.iup.tp.twitup.ihm.TwitListView;

import java.util.ArrayList;
import java.util.List;

public class ITwitCreateController implements  ITwitCreateObserver{

    public final TwitCreateView createTwitView;
    protected final List<ITwitUpObserver> listeners;
    protected final IDatabase mDatabase;
    protected final User user;

    public ITwitCreateController(IDatabase database, User user){
        this.user = user;
        this.mDatabase = database;
        createTwitView = new TwitCreateView();
        listeners = new ArrayList<>();
    }

    @Override
    public void notifySend(String text) {
        Twit twit = new Twit(user, text);
        mDatabase.addTwit(twit);
        listeners.forEach(listener -> listener.notifySendTwit());
    }

    @Override
    public void notifyCancel() {
        listeners.forEach( listener -> listener.notifyCancelCreate());
    }

    public void addListener(ITwitUpObserver listener) {
        listeners.add(listener);
    }

    public void removeListener(ITwitUpObserver listener) {
        listeners.add(listener);
    }
}
