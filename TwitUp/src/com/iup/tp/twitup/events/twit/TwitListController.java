package com.iup.tp.twitup.events.twit;

import com.iup.tp.twitup.core.ITwitUpObserver;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.ihm.TwitListView;

import java.util.ArrayList;
import java.util.List;

public class TwitListController implements ITwitListController{
    public final TwitListView twitListView;
    protected final IDatabase mDatabase;
    protected final List<ITwitUpObserver> listeners;
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
