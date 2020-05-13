package com.ouc.server.impl;

import com.ouc.entity.Yonghuzhuce;

public class UserNameLengthHandler extends  IHandler{
    @Override
    protected boolean MessageOk(Yonghuzhuce yonghuzhuce) {
        if(yonghuzhuce.getYonghuming().length() > 6 && yonghuzhuce.getYonghuming().length() < 18){
            if(next != null){
                return next.MessageOk(yonghuzhuce);
            }
            return true;
        }
        return false;
    }
}
