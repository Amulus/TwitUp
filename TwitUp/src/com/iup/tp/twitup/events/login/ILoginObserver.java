package com.iup.tp.twitup.events.login;

public interface ILoginObserver {
    void notifyLogin(String u, String p);
    void notifyRegister();

}
