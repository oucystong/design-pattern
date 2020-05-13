package com.ouc.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import com.ouc.dao.ZhiduMapper;
import com.ouc.entity.Zhidu;
import org.springframework.stereotype.Service;

import com.ouc.server.ZhiduServer;
@Service
public class ZhiduServerImpi implements ZhiduServer {
   @Resource
   private ZhiduMapper gdao;
	@Override
	public int add(Zhidu po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Zhidu po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Zhidu> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Zhidu> getsyzhidu1(Map<String, Object> map) {
		return gdao.getsyzhidu1(map);
	}
	public List<Zhidu> getsyzhidu2(Map<String, Object> map) {
		return gdao.getsyzhidu2(map);
	}
	public List<Zhidu> getsyzhidu3(Map<String, Object> map) {
		return gdao.getsyzhidu3(map);
	}
	
	@Override
	public Zhidu quchongZhidu(Map<String, Object> account) {
		return gdao.quchongZhidu(account);
	}

	@Override
	public List<Zhidu> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Zhidu> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Zhidu getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

