package com.ouc.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import com.ouc.dao.HuiyuanMapper;
import com.ouc.entity.Huiyuan;
import org.springframework.stereotype.Service;

import com.ouc.server.HuiyuanServer;
@Service
public class HuiyuanServerImpi implements HuiyuanServer {
   @Resource
   private HuiyuanMapper gdao;
	@Override
	public int add(Huiyuan po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Huiyuan po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Huiyuan> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Huiyuan> getsyhuiyuan1(Map<String, Object> map) {
		return gdao.getsyhuiyuan1(map);
	}
	public List<Huiyuan> getsyhuiyuan2(Map<String, Object> map) {
		return gdao.getsyhuiyuan2(map);
	}
	public List<Huiyuan> getsyhuiyuan3(Map<String, Object> map) {
		return gdao.getsyhuiyuan3(map);
	}
	
	@Override
	public Huiyuan quchongHuiyuan(Map<String, Object> account) {
		return gdao.quchongHuiyuan(account);
	}

	@Override
	public List<Huiyuan> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Huiyuan> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Huiyuan getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

