package com.iup.tp.twitup.core;

public interface ITwitUpObserver {

    void notifyRegister();
    void notifyLogin();
    void notifyCancel();
    void notifySendTwit();
    void notifyLogOut();
    void notifyCreateTwit();

    void notifyCancelCreate();

    void notifyUsers();
}
