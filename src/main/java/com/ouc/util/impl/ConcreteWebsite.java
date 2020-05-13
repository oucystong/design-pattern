package com.ouc.util.impl;

import com.ouc.entity.Allusers;
import com.ouc.util.Website;

/**
 * @description:
 * @author: oucystong
 **/
public class ConcreteWebsite extends Website {

    private String type="";

    public ConcreteWebsite(String type) {
        this.type = type+"shetuan";
    }

    public String getType() {
        return type;
    }

    @Override
    public void use(Allusers user) {
        System.out.println("网站名："+type+"使用者"+user.getUsername());
    }
}
