package com.ouc.server.impl;

import com.ouc.entity.Yonghuzhuce;

public abstract class IHandler {
    protected IHandler next;

    public void setNext(IHandler iHandler){
        next = iHandler;
    }

    public void printErrorMessage(){

    }

    protected  abstract boolean MessageOk(Yonghuzhuce yonghuzhuce);
}
