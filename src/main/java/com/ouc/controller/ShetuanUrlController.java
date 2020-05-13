package com.ouc.controller;

import com.ouc.entity.Allusers;
import com.ouc.entity.Shetuan;
import com.ouc.server.ShetuanUrlServer;
import com.ouc.server.impl.ShetuanUrlServerimpl;
import com.ouc.util.Website;
import com.ouc.util.WebsiteFactory;
import com.ouc.util.impl.ConcreteWebsite;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @description:
 * @author: oucystong
 **/


@Controller
public class ShetuanUrlController {


    @Resource
    private ShetuanUrlServer shetuanUrlServer;
    @RequestMapping("stURL/{url}")
    public String getUrl(@PathVariable("url") String url){
        //得到简URL
        String urlByName1 = shetuanUrlServer.getUrlByName1(url);
        //维护一个网站工厂，可以产生每种类型网站的全URL
        WebsiteFactory websiteFactory = new WebsiteFactory();
        ConcreteWebsite website = (ConcreteWebsite) websiteFactory.getWebSiteFactory(urlByName1);
        String allurl = website.getType();
        System.out.println(allurl);
        return allurl;
    }








}
