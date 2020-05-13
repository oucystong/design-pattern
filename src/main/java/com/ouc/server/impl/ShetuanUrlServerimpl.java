package com.ouc.server.impl;

import com.ouc.dao.ShetuanUrlMapper;
import com.ouc.server.ShetuanUrlServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: oucystong
 **/
@Service
public class ShetuanUrlServerimpl implements ShetuanUrlServer {
    @Resource
    private ShetuanUrlMapper shetuanUrlMapper;
    @Override
    public String getUrlByName1(String name) {
        String urlByName = shetuanUrlMapper.getUrlByName(name);
        return urlByName;
    }
}
