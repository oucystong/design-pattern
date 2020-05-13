package com.ouc.server;

import java.util.List;

import java.util.Map;

import com.ouc.entity.Huiyuan;

public interface HuiyuanServer {

  public int add(Huiyuan po);

  public int update(Huiyuan po);
  
  
  
  public int delete(int id);

  public List<Huiyuan> getAll(Map<String, Object> map);
  public List<Huiyuan> getsyhuiyuan1(Map<String, Object> map);
  public List<Huiyuan> getsyhuiyuan2(Map<String, Object> map);
  public List<Huiyuan> getsyhuiyuan3(Map<String, Object> map);
  public Huiyuan quchongHuiyuan(Map<String, Object> acount);

  public Huiyuan getById(int id);

  public List<Huiyuan> getByPage(Map<String, Object> map);

  public int getCount(Map<String, Object> map);

  public List<Huiyuan> select(Map<String, Object> map);
}
//	所有List
