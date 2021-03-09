package com.iup.tp.twitup.events.register;

public interface IRegisterObserver {
    void notifyRegister(String u, String p, String t);
    void notifyCancel();
}
