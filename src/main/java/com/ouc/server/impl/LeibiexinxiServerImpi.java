package com.ouc.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import com.ouc.dao.LeibiexinxiMapper;
import com.ouc.entity.Leibiexinxi;
import com.ouc.server.LeibiexinxiServer;
import org.springframework.stereotype.Service;

@Service
public class LeibiexinxiServerImpi implements LeibiexinxiServer {
   @Resource
   private LeibiexinxiMapper gdao;
	@Override
	public int add(Leibiexinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Leibiexinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Leibiexinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Leibiexinxi> getsyleibiexinxi1(Map<String, Object> map) {
		return gdao.getsyleibiexinxi1(map);
	}
	public List<Leibiexinxi> getsyleibiexinxi2(Map<String, Object> map) {
		return gdao.getsyleibiexinxi2(map);
	}
	public List<Leibiexinxi> getsyleibiexinxi3(Map<String, Object> map) {
		return gdao.getsyleibiexinxi3(map);
	}
	
	@Override
	public Leibiexinxi quchongLeibiexinxi(Map<String, Object> account) {
		return gdao.quchongLeibiexinxi(account);
	}

	@Override
	public List<Leibiexinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Leibiexinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Leibiexinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

