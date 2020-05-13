package com.ouc.server;

public interface Operation {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notice(String message);
}
