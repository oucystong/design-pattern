package com.ouc.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import com.ouc.dao.XiaoxiMapper;
import com.ouc.entity.Xiaoxi;
import org.springframework.stereotype.Service;

import com.ouc.server.XiaoxiServer;
@Service
public class XiaoxiServerImpi implements XiaoxiServer {
   @Resource
   private XiaoxiMapper gdao;
	@Override
	public int add(Xiaoxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Xiaoxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Xiaoxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Xiaoxi> getsyxiaoxi1(Map<String, Object> map) {
		return gdao.getsyxiaoxi1(map);
	}
	public List<Xiaoxi> getsyxiaoxi2(Map<String, Object> map) {
		return gdao.getsyxiaoxi2(map);
	}
	public List<Xiaoxi> getsyxiaoxi3(Map<String, Object> map) {
		return gdao.getsyxiaoxi3(map);
	}
	
	@Override
	public Xiaoxi quchongXiaoxi(Map<String, Object> account) {
		return gdao.quchongXiaoxi(account);
	}

	@Override
	public List<Xiaoxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Xiaoxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Xiaoxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

