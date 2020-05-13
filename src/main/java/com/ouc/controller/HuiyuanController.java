package com.ouc.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ouc.entity.Huiyuan;
import com.ouc.server.HuiyuanServer;
import com.ouc.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class HuiyuanController {
	@Resource
	private HuiyuanServer huiyuanService;


   
	@RequestMapping("addHuiyuan.do")
	public String addHuiyuan(HttpServletRequest request, Huiyuan huiyuan, HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		huiyuan.setAddtime(time.toString().substring(0, 19));
		huiyuanService.add(huiyuan);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "huiyuanList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:huiyuanList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateHuiyuan.do")
	public String doUpdateHuiyuan(int id,ModelMap map,Huiyuan huiyuan){
		huiyuan=huiyuanService.getById(id);
		map.put("huiyuan", huiyuan);
		return "huiyuan_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("huiyuanDetail.do")
	public String huiyuanDetail(int id,ModelMap map,Huiyuan huiyuan){
		huiyuan=huiyuanService.getById(id);
		map.put("huiyuan", huiyuan);
		return "huiyuan_detail";
	}
//	前台详细
	@RequestMapping("hyDetail.do")
	public String hyDetail(int id,ModelMap map,Huiyuan huiyuan){
		huiyuan=huiyuanService.getById(id);
		map.put("huiyuan", huiyuan);
		return "huiyuandetail";
	}
//	
	@RequestMapping("updateHuiyuan.do")
	public String updateHuiyuan(int id,ModelMap map,Huiyuan huiyuan,HttpServletRequest request,HttpSession session){
		huiyuanService.update(huiyuan);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:huiyuanList.do";
	}

//	分页查询
	@RequestMapping("huiyuanList.do")
	public String huiyuanList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huiyuan huiyuan, String shetuanbianhao, String shetuanmingcheng, String leibie, String shechang, String shechangxingming, String yonghuming, String xingming, String dianhua, String xueyuan, String zhuanye, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}
		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shechang==null||shechang.equals("")){pmap.put("shechang", null);}else{pmap.put("shechang", shechang);}
		if(shechangxingming==null||shechangxingming.equals("")){pmap.put("shechangxingming", null);}else{pmap.put("shechangxingming", shechangxingming);}
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(xueyuan==null||xueyuan.equals("")){pmap.put("xueyuan", null);}else{pmap.put("xueyuan", xueyuan);}
		if(zhuanye==null||zhuanye.equals("")){pmap.put("zhuanye", null);}else{pmap.put("zhuanye", zhuanye);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=huiyuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huiyuan> list=huiyuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huiyuan_list";
	}
	
	@RequestMapping("huiyuanList3.do")
	public String huiyuanList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huiyuan huiyuan, String shetuanbianhao, String shetuanmingcheng, String leibie, String shechang, String shechangxingming, String yonghuming, String xingming, String dianhua, String xueyuan, String zhuanye, String beizhu, String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("shechang", (String)request.getSession().getAttribute("username"));
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}
		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shechangxingming==null||shechangxingming.equals("")){pmap.put("shechangxingming", null);}else{pmap.put("shechangxingming", shechangxingming);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(xueyuan==null||xueyuan.equals("")){pmap.put("xueyuan", null);}else{pmap.put("xueyuan", xueyuan);}
		if(zhuanye==null||zhuanye.equals("")){pmap.put("zhuanye", null);}else{pmap.put("zhuanye", zhuanye);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		
		int total=huiyuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huiyuan> list=huiyuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huiyuan_list3";
	}
	@RequestMapping("huiyuanList2.do")
	public String huiyuanList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huiyuan huiyuan, String shetuanbianhao, String shetuanmingcheng, String leibie, String shechang, String shechangxingming, String yonghuming, String xingming, String dianhua, String xueyuan, String zhuanye, String beizhu, String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("yonghuming", (String)request.getSession().getAttribute("username"));
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}
		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shechangxingming==null||shechangxingming.equals("")){pmap.put("shechangxingming", null);}else{pmap.put("shechangxingming", shechangxingming);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(xueyuan==null||xueyuan.equals("")){pmap.put("xueyuan", null);}else{pmap.put("xueyuan", xueyuan);}
		if(zhuanye==null||zhuanye.equals("")){pmap.put("zhuanye", null);}else{pmap.put("zhuanye", zhuanye);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		
		int total=huiyuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huiyuan> list=huiyuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huiyuan_list2";
	}
	@RequestMapping("huiyuanList4.do")
	public String huiyuanList4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huiyuan huiyuan, String shetuanbianhao, String shetuanmingcheng, String leibie, String shechang, String shechangxingming, String yonghuming, String xingming, String dianhua, String xueyuan, String zhuanye, String beizhu, String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("xingming", (String)request.getSession().getAttribute("username"));
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}
		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shechangxingming==null||shechangxingming.equals("")){pmap.put("shechangxingming", null);}else{pmap.put("shechangxingming", shechangxingming);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(xueyuan==null||xueyuan.equals("")){pmap.put("xueyuan", null);}else{pmap.put("xueyuan", xueyuan);}
		if(zhuanye==null||zhuanye.equals("")){pmap.put("zhuanye", null);}else{pmap.put("zhuanye", zhuanye);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		
		int total=huiyuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huiyuan> list=huiyuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huiyuan_list4";
	}
	
	
	@RequestMapping("hyList.do")
	public String hyList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huiyuan huiyuan, String shetuanbianhao, String shetuanmingcheng, String leibie, String shechang, String shechangxingming, String yonghuming, String xingming, String dianhua, String xueyuan, String zhuanye, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}
		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shechang==null||shechang.equals("")){pmap.put("shechang", null);}else{pmap.put("shechang", shechang);}
		if(shechangxingming==null||shechangxingming.equals("")){pmap.put("shechangxingming", null);}else{pmap.put("shechangxingming", shechangxingming);}
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(xueyuan==null||xueyuan.equals("")){pmap.put("xueyuan", null);}else{pmap.put("xueyuan", xueyuan);}
		if(zhuanye==null||zhuanye.equals("")){pmap.put("zhuanye", null);}else{pmap.put("zhuanye", zhuanye);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=huiyuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huiyuan> list=huiyuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huiyuanlist";
	}
	
	@RequestMapping("deleteHuiyuan.do")
	public String deleteHuiyuan(int id,HttpServletRequest request){
		huiyuanService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:huiyuanList.do";
	}
	
	
}
