package com.ouc.util;

import com.ouc.util.impl.ConcreteWebsite;

import java.util.HashMap;

/**
 * @description:
 * @author: oucystong
 **/
public class WebsiteFactory {
    private HashMap<String, ConcreteWebsite> pool=new HashMap<>();
    public Website getWebSiteFactory(String type){
        if(!pool.containsKey(type)){
            pool.put(type,new ConcreteWebsite(type));
        }

        return (Website)pool.get(type);
    }
}
