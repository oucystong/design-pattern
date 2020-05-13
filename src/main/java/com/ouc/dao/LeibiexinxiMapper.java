package com.ouc.dao;

import java.util.List;
import java.util.Map;

import com.ouc.entity.Leibiexinxi;

public interface LeibiexinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Leibiexinxi record);

    int insertSelective(Leibiexinxi record);

    Leibiexinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Leibiexinxi record);
	
    int updateByPrimaryKey(Leibiexinxi record);
	public Leibiexinxi quchongLeibiexinxi(Map<String, Object> leibie);
	public List<Leibiexinxi> getAll(Map<String, Object> map);
	public List<Leibiexinxi> getsyleibiexinxi1(Map<String, Object> map);
	public List<Leibiexinxi> getsyleibiexinxi3(Map<String, Object> map);
	public List<Leibiexinxi> getsyleibiexinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Leibiexinxi> getByPage(Map<String, Object> map);
	public List<Leibiexinxi> select(Map<String, Object> map);
//	所有List
}

