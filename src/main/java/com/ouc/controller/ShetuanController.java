package com.ouc.controller;

import java.io.IOException;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ouc.entity.Shetuan;
import com.ouc.server.ShetuanServer;
import com.ouc.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.sf.json.JSONObject;

import java.sql.SQLException;

@Controller
public class ShetuanController {
	@Resource
	private ShetuanServer shetuanService;


   
	@RequestMapping("addShetuan.do")
	public String addShetuan(HttpServletRequest request, Shetuan shetuan, HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shetuan.setAddtime(time.toString().substring(0, 19));
		shetuanService.add(shetuan);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shetuanList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shetuanList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShetuan.do")
	public String doUpdateShetuan(int id,ModelMap map,Shetuan shetuan){
		shetuan=shetuanService.getById(id);
		map.put("shetuan", shetuan);
		return "shetuan_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shetuanDetail.do")
	public String shetuanDetail(int id,ModelMap map,Shetuan shetuan){
		shetuan=shetuanService.getById(id);
		map.put("shetuan", shetuan);
		return "shetuan_detail";
	}
//	前台详细
	@RequestMapping("stDetail.do")
	public String stDetail(int id,ModelMap map,Shetuan shetuan){
		shetuan=shetuanService.getById(id);
		map.put("shetuan", shetuan);
		return "shetuandetail";
	}
//	
	@RequestMapping("updateShetuan.do")
	public String updateShetuan(int id,ModelMap map,Shetuan shetuan,HttpServletRequest request,HttpSession session){
		shetuanService.update(shetuan);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shetuanList.do";
	}

//	分页查询
	@RequestMapping("shetuanList.do")
	public String shetuanList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuan shetuan, String shetuanbianhao, String shetuanmingcheng, String leibie, String tupian, String dianjilv1,String dianjilv2, String shechang, String shechangxingming, String shetuanjieshao, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}
		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(dianjilv1==null||dianjilv1.equals("")){pmap.put("dianjilv1", null);}else{pmap.put("dianjilv1", dianjilv1);}
		if(dianjilv2==null||dianjilv2.equals("")){pmap.put("dianjilv2", null);}else{pmap.put("dianjilv2", dianjilv2);}
		if(shechang==null||shechang.equals("")){pmap.put("shechang", null);}else{pmap.put("shechang", shechang);}
		if(shechangxingming==null||shechangxingming.equals("")){pmap.put("shechangxingming", null);}else{pmap.put("shechangxingming", shechangxingming);}
		if(shetuanjieshao==null||shetuanjieshao.equals("")){pmap.put("shetuanjieshao", null);}else{pmap.put("shetuanjieshao", shetuanjieshao);}
		
		int total=shetuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuan> list=shetuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuan_list";
	}
	
	@RequestMapping("shetuanList2.do")
	public String shetuanList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuan shetuan, String shetuanbianhao, String shetuanmingcheng, String leibie, String tupian, String dianjilv1,String dianjilv2, String shechang, String shechangxingming, String shetuanjieshao, String issh,HttpServletRequest request){
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
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(dianjilv1==null||dianjilv1.equals("")){pmap.put("dianjilv1", null);}else{pmap.put("dianjilv1", dianjilv1);}
		if(dianjilv2==null||dianjilv2.equals("")){pmap.put("dianjilv2", null);}else{pmap.put("dianjilv2", dianjilv2);}
		if(shechangxingming==null||shechangxingming.equals("")){pmap.put("shechangxingming", null);}else{pmap.put("shechangxingming", shechangxingming);}
		if(shetuanjieshao==null||shetuanjieshao.equals("")){pmap.put("shetuanjieshao", null);}else{pmap.put("shetuanjieshao", shetuanjieshao);}
		
		
		int total=shetuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuan> list=shetuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuan_list2";
	}
	
	
	@RequestMapping("stList.do")
	public String stList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuan shetuan, String shetuanbianhao, String shetuanmingcheng, String leibie, String tupian, String dianjilv1,String dianjilv2, String shechang, String shechangxingming, String shetuanjieshao, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}
		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(dianjilv1==null||dianjilv1.equals("")){pmap.put("dianjilv1", null);}else{pmap.put("dianjilv1", dianjilv1);}
		if(dianjilv2==null||dianjilv2.equals("")){pmap.put("dianjilv2", null);}else{pmap.put("dianjilv2", dianjilv2);}
		if(shechang==null||shechang.equals("")){pmap.put("shechang", null);}else{pmap.put("shechang", shechang);}
		if(shechangxingming==null||shechangxingming.equals("")){pmap.put("shechangxingming", null);}else{pmap.put("shechangxingming", shechangxingming);}
		if(shetuanjieshao==null||shetuanjieshao.equals("")){pmap.put("shetuanjieshao", null);}else{pmap.put("shetuanjieshao", shetuanjieshao);}
		
		int total=shetuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuan> list=shetuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanlist";
	}
	
	
	@RequestMapping("stListtp.do")
	public String stListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuan shetuan, String shetuanbianhao, String shetuanmingcheng, String leibie, String tupian, String dianjilv1,String dianjilv2, String shechang, String shechangxingming, String shetuanjieshao, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}
		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(dianjilv1==null||dianjilv1.equals("")){pmap.put("dianjilv1", null);}else{pmap.put("dianjilv1", dianjilv1);}
		if(dianjilv2==null||dianjilv2.equals("")){pmap.put("dianjilv2", null);}else{pmap.put("dianjilv2", dianjilv2);}
		if(shechang==null||shechang.equals("")){pmap.put("shechang", null);}else{pmap.put("shechang", shechang);}
		if(shechangxingming==null||shechangxingming.equals("")){pmap.put("shechangxingming", null);}else{pmap.put("shechangxingming", shechangxingming);}
		if(shetuanjieshao==null||shetuanjieshao.equals("")){pmap.put("shetuanjieshao", null);}else{pmap.put("shetuanjieshao", shetuanjieshao);}
		
		int total=shetuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuan> list=shetuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanlisttp";
	}
	
	
	@RequestMapping("deleteShetuan.do")
	public String deleteShetuan(int id,HttpServletRequest request){
		shetuanService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shetuanList.do";
	}
	
	@RequestMapping("quchongShetuan.do")
	public void quchongShetuan(Shetuan shetuan,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("shetuanmingcheng", shetuan.getShetuanmingcheng());
		   System.out.println("shetuanmingcheng==="+shetuan.getShetuanmingcheng());
		   System.out.println("shetuanmingcheng222==="+shetuanService.quchongShetuan(map));
		   JSONObject obj=new JSONObject();
		   if(shetuanService.quchongShetuan(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "社团名称可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
