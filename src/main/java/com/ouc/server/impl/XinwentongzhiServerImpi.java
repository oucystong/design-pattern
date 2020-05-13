package com.ouc.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import com.ouc.dao.XinwentongzhiMapper;
import com.ouc.entity.Xinwentongzhi;
import com.ouc.server.XinwentongzhiServer;
import org.springframework.stereotype.Service;

@Service
public class XinwentongzhiServerImpi implements XinwentongzhiServer {
   @Resource
   private XinwentongzhiMapper gdao;
	@Override
	public int add(Xinwentongzhi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Xinwentongzhi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Xinwentongzhi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	
	@Override
	public List<Xinwentongzhi> getsyxinwentongzhi1(Map<String, Object> map) {
		return gdao.getsyxinwentongzhi1(map);
	}
	@Override
	public List<Xinwentongzhi> getsyxinwentongzhi2(Map<String, Object> map) {
		return gdao.getsyxinwentongzhi2(map);
	}
	@Override
	public List<Xinwentongzhi> getsyxinwentongzhi3(Map<String, Object> map) {
		return gdao.getsyxinwentongzhi3(map);
	}
	
	
	@Override
	public Xinwentongzhi quchongXinwentongzhi(String account) {
		return null;
	}

	@Override
	public List<Xinwentongzhi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Xinwentongzhi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Xinwentongzhi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

