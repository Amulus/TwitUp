package com.iup.tp.twitup.events.login;

import com.iup.tp.twitup.datamodel.User;

public interface ILoginObserver {
    void notifyLogin(String u, String p);
    void notifyRegister();

}
