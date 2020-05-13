package com.ouc.server.impl;

import com.ouc.entity.Yonghuzhuce;

public class RegisterMessageHelper {

    private IHandler iHandler;

    public RegisterMessageHelper(IHandler iHandler) {
        this.iHandler = iHandler;
    }

    public RegisterMessageHelper() {
    }

    public boolean MessageIsTrue(Yonghuzhuce yonghuzhuce){
        return iHandler.MessageOk(yonghuzhuce);
    }
}
