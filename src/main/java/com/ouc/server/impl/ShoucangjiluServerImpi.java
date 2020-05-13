package com.ouc.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import com.ouc.dao.ShoucangjiluMapper;
import com.ouc.entity.Shoucangjilu;
import com.ouc.server.ShoucangjiluServer;
import org.springframework.stereotype.Service;

@Service
public class ShoucangjiluServerImpi implements ShoucangjiluServer {
   @Resource
   private ShoucangjiluMapper gdao;
	@Override
	public int add(Shoucangjilu po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shoucangjilu po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shoucangjilu> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}

	@Override
	public Shoucangjilu quchongShoucangjilu(Map<String, Object> account) {
		return null;
	}

	@Override
	public List<Shoucangjilu> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shoucangjilu> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shoucangjilu getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

