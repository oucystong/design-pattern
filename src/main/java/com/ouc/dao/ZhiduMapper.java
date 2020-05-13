package com.ouc.dao;

import java.util.List;
import java.util.Map;

import com.ouc.entity.Zhidu;

public interface ZhiduMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zhidu record);

    int insertSelective(Zhidu record);

    Zhidu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zhidu record);
	
    int updateByPrimaryKey(Zhidu record);
	public Zhidu quchongZhidu(Map<String, Object> dengjiren);
	public List<Zhidu> getAll(Map<String, Object> map);
	public List<Zhidu> getsyzhidu1(Map<String, Object> map);
	public List<Zhidu> getsyzhidu3(Map<String, Object> map);
	public List<Zhidu> getsyzhidu2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Zhidu> getByPage(Map<String, Object> map);
	public List<Zhidu> select(Map<String, Object> map);
//	所有List
}

