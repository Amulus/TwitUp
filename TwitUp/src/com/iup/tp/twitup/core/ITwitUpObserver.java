package com.iup.tp.twitup.core;

public interface ITwitUpObserver {

    void notifyRegisterToLogin();
    void notifyLoginToRegister();
    void notifyLoginToTwitList();
}
