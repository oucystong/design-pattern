package com.ouc.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import com.ouc.dao.ShetuanMapper;
import com.ouc.entity.Shetuan;
import org.springframework.stereotype.Service;

import com.ouc.server.ShetuanServer;
@Service
public class ShetuanServerImpi implements ShetuanServer {
   @Resource
   private ShetuanMapper gdao;
	@Override
	public int add(Shetuan po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shetuan po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shetuan> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shetuan> getsyshetuan1(Map<String, Object> map) {
		return gdao.getsyshetuan1(map);
	}
	public List<Shetuan> getsyshetuan2(Map<String, Object> map) {
		return gdao.getsyshetuan2(map);
	}
	public List<Shetuan> getsyshetuan3(Map<String, Object> map) {
		return gdao.getsyshetuan3(map);
	}
	
	@Override
	public Shetuan quchongShetuan(Map<String, Object> account) {
		return gdao.quchongShetuan(account);
	}

	@Override
	public List<Shetuan> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shetuan> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shetuan getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

