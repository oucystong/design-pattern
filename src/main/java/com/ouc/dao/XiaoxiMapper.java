package com.ouc.dao;

import java.util.List;
import java.util.Map;

import com.ouc.entity.Xiaoxi;

public interface XiaoxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Xiaoxi record);

    int insertSelective(Xiaoxi record);

    Xiaoxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Xiaoxi record);
	
    int updateByPrimaryKey(Xiaoxi record);
	public Xiaoxi quchongXiaoxi(Map<String, Object> dengjiren);
	public List<Xiaoxi> getAll(Map<String, Object> map);
	public List<Xiaoxi> getsyxiaoxi1(Map<String, Object> map);
	public List<Xiaoxi> getsyxiaoxi3(Map<String, Object> map);
	public List<Xiaoxi> getsyxiaoxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Xiaoxi> getByPage(Map<String, Object> map);
	public List<Xiaoxi> select(Map<String, Object> map);
//	所有List
}

