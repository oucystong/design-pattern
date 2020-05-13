package com.ouc.server.impl;

import com.ouc.dao.YonghuzhuceMapper;
import com.ouc.entity.Yonghuzhuce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YonghuzhuceService {

    @Autowired
    YonghuzhuceMapper yonghuzhuceMapper;

    /**
     *  判断用户是否存在
     * @param yonghuzhuce 用户注册实体类
     * @return true：表示存在该用户   false：表示不存在该用户
     */
    public boolean isExitUserName(Yonghuzhuce yonghuzhuce){
        List<Yonghuzhuce> yonghuzhuces =
                yonghuzhuceMapper.selectYonghuzhuceByYonghuming(yonghuzhuce.getYonghuming());
        //如果list集合为空，表示不存在该用户名，可以注册
        if(yonghuzhuces == null || yonghuzhuces.isEmpty()){
            return false;
        }
        return true;
    }
}
