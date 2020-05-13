package com.ouc.server;

import java.util.List;

import java.util.Map;

import com.ouc.entity.Shetuan;

public interface ShetuanServer {

  public int add(Shetuan po);

  public int update(Shetuan po);
  
  
  
  public int delete(int id);

  public List<Shetuan> getAll(Map<String, Object> map);
  public List<Shetuan> getsyshetuan1(Map<String, Object> map);
  public List<Shetuan> getsyshetuan2(Map<String, Object> map);
  public List<Shetuan> getsyshetuan3(Map<String, Object> map);
  public Shetuan quchongShetuan(Map<String, Object> acount);

  public Shetuan getById(int id);

  public List<Shetuan> getByPage(Map<String, Object> map);

  public int getCount(Map<String, Object> map);

  public List<Shetuan> select(Map<String, Object> map);
}
//	所有List
