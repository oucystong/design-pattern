package com.ouc.controller;

import java.util.List;

import javax.annotation.Resource;

import com.ouc.entity.Shetuan;
import com.ouc.entity.Xinwentongzhi;
import com.ouc.entity.Yonghuzhuce;
import com.ouc.server.XinwentongzhiServer;
import com.ouc.server.YonghuzhuceServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


//jixacxishxu1

import com.ouc.server.ShetuanServer;
//jixacxishxu2


@Controller
public class IndexController {
	
	
	@Resource
	private XinwentongzhiServer xinwentongzhiService;
	@Resource
	private YonghuzhuceServer yonghuzhuceServer;
	@Resource
	private ShetuanServer shetuanServer;
	//jixacxishxu3
	
	
	
//	首页显示内容
	@RequestMapping("index.do")
	public String showIndex(ModelMap map){

		List<Xinwentongzhi> syxinwentongzhi1=xinwentongzhiService.getsyxinwentongzhi1(null);
		List<Xinwentongzhi> syxinwentongzhi2=xinwentongzhiService.getsyxinwentongzhi2(null);
		List<Xinwentongzhi> syxinwentongzhi3=xinwentongzhiService.getsyxinwentongzhi3(null);

		List<Yonghuzhuce> syyonghuzhuce1=yonghuzhuceServer.getsyyonghuzhuce1(null);
		List<Shetuan> syshetuan1=shetuanServer.getsyshetuan1(null);
		List<Shetuan> syshetuan2=shetuanServer.getsyshetuan2(null);
		List<Shetuan> syshetuan3=shetuanServer.getsyshetuan3(null);
		//jixacxishxu4
		
	    map.put("syxinwentongzhi1", syxinwentongzhi1);
	    map.put("syxinwentongzhi2", syxinwentongzhi2);
	    map.put("syxinwentongzhi3", syxinwentongzhi3);
	    map.put("syyonghuzhuce1", syyonghuzhuce1);
	    map.put("syshetuan1", syshetuan1);
	    map.put("syshetuan2", syshetuan2);
	    map.put("syshetuan3", syshetuan3);
	    //jixacxishxu5

		return "default";
	}

	

	
}
