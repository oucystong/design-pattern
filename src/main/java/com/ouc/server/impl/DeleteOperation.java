package com.ouc.server.impl;

import com.ouc.server.Observer;
import com.ouc.server.Operation;

import java.util.ArrayList;
import java.util.List;

public class DeleteOperation implements Operation {

    private String name = "delete";

    private List<Observer> observerList = new ArrayList<Observer>();
    @Override
    public void addObserver(Observer observer) {
        if(!observerList.contains(observer)){
            observerList.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if(observerList.contains(observer)){
            observerList.remove(observer);
        }
    }

    @Override
    public void notice(String message) {
        for(Observer observer:observerList){
            observer.update(message,name);
        }
    }
}

