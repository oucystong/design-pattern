package com.ouc.server.impl;

import com.ouc.entity.Yonghuzhuce;

public class UserPasswordHandler  extends IHandler{

    @Override
    protected boolean MessageOk(Yonghuzhuce yonghuzhuce) {
        if(yonghuzhuce.getMima().length() > 8 && yonghuzhuce.getMima().length() < 18){
            if(next != null){
                return next.MessageOk(yonghuzhuce);
            }
            return true;
        }
        return false;

    }
}
