package com.iup.tp.twitup.events.twit;

import com.iup.tp.twitup.core.ITwitUpObserver;
import com.iup.tp.twitup.core.Twitup;
import com.iup.tp.twitup.datamodel.Database;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.TwitListView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TwitListController implements ITwitListController{
    public TwitListView twitListView;
    protected IDatabase mDatabase;
    protected List<ITwitUpObserver> listeners;
    public TwitListController(IDatabase database){
        mDatabase = database;
        twitListView = new TwitListView(mDatabase.getTwits());
        listeners = new ArrayList<>();
    }

    public void addListener(ITwitUpObserver listener) {
        listeners.add(listener);
    }

    public void removeListener(ITwitUpObserver listener) {
        listeners.add(listener);
    }
}
