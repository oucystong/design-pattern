package com.ouc.dao;

import java.util.List;
import java.util.Map;

import com.ouc.entity.Huiyuan;

public interface HuiyuanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Huiyuan record);

    int insertSelective(Huiyuan record);

    Huiyuan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Huiyuan record);
	
    int updateByPrimaryKey(Huiyuan record);
	public Huiyuan quchongHuiyuan(Map<String, Object> yonghuming);
	public List<Huiyuan> getAll(Map<String, Object> map);
	public List<Huiyuan> getsyhuiyuan1(Map<String, Object> map);
	public List<Huiyuan> getsyhuiyuan3(Map<String, Object> map);
	public List<Huiyuan> getsyhuiyuan2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Huiyuan> getByPage(Map<String, Object> map);
	public List<Huiyuan> select(Map<String, Object> map);
//	所有List
}

