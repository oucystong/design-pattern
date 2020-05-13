package com.ouc.dao;

import java.util.List;
import java.util.Map;

import com.ouc.entity.Shetuan;

public interface ShetuanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shetuan record);

    int insertSelective(Shetuan record);

    Shetuan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shetuan record);
	
    int updateByPrimaryKey(Shetuan record);
	public Shetuan quchongShetuan(Map<String, Object> shechang);
	public List<Shetuan> getAll(Map<String, Object> map);
	public List<Shetuan> getsyshetuan1(Map<String, Object> map);
	public List<Shetuan> getsyshetuan3(Map<String, Object> map);
	public List<Shetuan> getsyshetuan2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shetuan> getByPage(Map<String, Object> map);
	public List<Shetuan> select(Map<String, Object> map);
//	所有List
}

