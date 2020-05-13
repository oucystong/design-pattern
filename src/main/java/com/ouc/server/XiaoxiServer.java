package com.ouc.server;

import java.util.List;

import java.util.Map;

import com.ouc.entity.Xiaoxi;

public interface XiaoxiServer {

  public int add(Xiaoxi po);

  public int update(Xiaoxi po);
  
  
  
  public int delete(int id);

  public List<Xiaoxi> getAll(Map<String, Object> map);
  public List<Xiaoxi> getsyxiaoxi1(Map<String, Object> map);
  public List<Xiaoxi> getsyxiaoxi2(Map<String, Object> map);
  public List<Xiaoxi> getsyxiaoxi3(Map<String, Object> map);
  public Xiaoxi quchongXiaoxi(Map<String, Object> acount);

  public Xiaoxi getById(int id);

  public List<Xiaoxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String, Object> map);

  public List<Xiaoxi> select(Map<String, Object> map);
}
//	所有List
