package com.ouc.server;

import java.util.List;

import java.util.Map;

import com.ouc.entity.Leibiexinxi;

public interface LeibiexinxiServer {

  public int add(Leibiexinxi po);

  public int update(Leibiexinxi po);
  
  
  
  public int delete(int id);

  public List<Leibiexinxi> getAll(Map<String, Object> map);
  public List<Leibiexinxi> getsyleibiexinxi1(Map<String, Object> map);
  public List<Leibiexinxi> getsyleibiexinxi2(Map<String, Object> map);
  public List<Leibiexinxi> getsyleibiexinxi3(Map<String, Object> map);
  public Leibiexinxi quchongLeibiexinxi(Map<String, Object> acount);

  public Leibiexinxi getById(int id);

  public List<Leibiexinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String, Object> map);

  public List<Leibiexinxi> select(Map<String, Object> map);
}
//	所有List
