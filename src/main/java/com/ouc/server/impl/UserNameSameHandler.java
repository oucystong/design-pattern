package com.ouc.server.impl;

import com.ouc.entity.Yonghuzhuce;
import org.springframework.beans.factory.annotation.Autowired;

public class UserNameSameHandler  extends  IHandler{
    @Autowired
    YonghuzhuceService yonghuzhuceService;
    @Override
    protected boolean MessageOk(Yonghuzhuce yonghuzhuce) {
        boolean b = yonghuzhuceService.isExitUserName(yonghuzhuce);
        // b为true:存在该用户，不能注册；false 表示不存在该用户，可以注册
        if(!b){
            if(next != null){
                return next.MessageOk(yonghuzhuce);
            }
            return true;
        }
        return false;
    }
}
