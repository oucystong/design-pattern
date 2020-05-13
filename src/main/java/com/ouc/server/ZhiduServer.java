package com.ouc.server;

import java.util.List;

import java.util.Map;

import com.ouc.entity.Zhidu;

public interface ZhiduServer {

  public int add(Zhidu po);

  public int update(Zhidu po);
  
  
  
  public int delete(int id);

  public List<Zhidu> getAll(Map<String, Object> map);
  public List<Zhidu> getsyzhidu1(Map<String, Object> map);
  public List<Zhidu> getsyzhidu2(Map<String, Object> map);
  public List<Zhidu> getsyzhidu3(Map<String, Object> map);
  public Zhidu quchongZhidu(Map<String, Object> acount);

  public Zhidu getById(int id);

  public List<Zhidu> getByPage(Map<String, Object> map);

  public int getCount(Map<String, Object> map);

  public List<Zhidu> select(Map<String, Object> map);
}
//	所有List
