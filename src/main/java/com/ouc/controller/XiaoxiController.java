package com.ouc.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ouc.entity.Xiaoxi;
import com.ouc.server.XiaoxiServer;
import com.ouc.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class XiaoxiController {
	@Resource
	private XiaoxiServer xiaoxiService;


   
	@RequestMapping("addXiaoxi.do")
	public String addXiaoxi(HttpServletRequest request, Xiaoxi xiaoxi, HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		xiaoxi.setAddtime(time.toString().substring(0, 19));
		xiaoxiService.add(xiaoxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "xiaoxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:xiaoxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateXiaoxi.do")
	public String doUpdateXiaoxi(int id,ModelMap map,Xiaoxi xiaoxi){
		xiaoxi=xiaoxiService.getById(id);
		map.put("xiaoxi", xiaoxi);
		return "xiaoxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("xiaoxiDetail.do")
	public String xiaoxiDetail(int id,ModelMap map,Xiaoxi xiaoxi){
		xiaoxi=xiaoxiService.getById(id);
		map.put("xiaoxi", xiaoxi);
		return "xiaoxi_detail";
	}
//	前台详细
	@RequestMapping("xxDetail.do")
	public String xxDetail(int id,ModelMap map,Xiaoxi xiaoxi){
		xiaoxi=xiaoxiService.getById(id);
		map.put("xiaoxi", xiaoxi);
		return "xiaoxidetail";
	}
//	
	@RequestMapping("updateXiaoxi.do")
	public String updateXiaoxi(int id,ModelMap map,Xiaoxi xiaoxi,HttpServletRequest request,HttpSession session){
		xiaoxiService.update(xiaoxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:xiaoxiList.do";
	}

//	分页查询
	@RequestMapping("xiaoxiList.do")
	public String xiaoxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiaoxi xiaoxi, String shetuanbianhao, String shetuanmingcheng, String leibie, String tongzhimingcheng, String riqi1,String riqi2, String dengjiren, String neirong){
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
		if(tongzhimingcheng==null||tongzhimingcheng.equals("")){pmap.put("tongzhimingcheng", null);}else{pmap.put("tongzhimingcheng", tongzhimingcheng);}
		if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}
		if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}
		if(dengjiren==null||dengjiren.equals("")){pmap.put("dengjiren", null);}else{pmap.put("dengjiren", dengjiren);}
		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}
		
		int total=xiaoxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiaoxi> list=xiaoxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiaoxi_list";
	}
	
	@RequestMapping("xiaoxiList4.do")
	public String xiaoxiList4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiaoxi xiaoxi, String shetuanbianhao, String shetuanmingcheng, String leibie, String tongzhimingcheng, String riqi1,String riqi2, String dengjiren, String neirong,HttpServletRequest request){
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
		
		pmap.put("shetuanmingcheng", (String)request.getSession().getAttribute("username"));
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}
		if(tongzhimingcheng==null||tongzhimingcheng.equals("")){pmap.put("tongzhimingcheng", null);}else{pmap.put("tongzhimingcheng", tongzhimingcheng);}
		if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}
		if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}
		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}
		
		
		int total=xiaoxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiaoxi> list=xiaoxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiaoxi_list4";
	}
	@RequestMapping("xiaoxiList3.do")
	public String xiaoxiList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiaoxi xiaoxi, String shetuanbianhao, String shetuanmingcheng, String leibie, String tongzhimingcheng, String riqi1,String riqi2, String dengjiren, String neirong,HttpServletRequest request){
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
		
		pmap.put("leibie", (String)request.getSession().getAttribute("username"));
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}
		if(tongzhimingcheng==null||tongzhimingcheng.equals("")){pmap.put("tongzhimingcheng", null);}else{pmap.put("tongzhimingcheng", tongzhimingcheng);}
		if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}
		if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}
		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}
		
		
		int total=xiaoxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiaoxi> list=xiaoxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiaoxi_list3";
	}
	@RequestMapping("xiaoxiList2.do")
	public String xiaoxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiaoxi xiaoxi, String shetuanbianhao, String shetuanmingcheng, String leibie, String tongzhimingcheng, String riqi1,String riqi2, String dengjiren, String neirong,HttpServletRequest request){
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
		
		pmap.put("dengjiren", (String)request.getSession().getAttribute("username"));
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}
		if(tongzhimingcheng==null||tongzhimingcheng.equals("")){pmap.put("tongzhimingcheng", null);}else{pmap.put("tongzhimingcheng", tongzhimingcheng);}
		if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}
		if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}
		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}
		
		
		int total=xiaoxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiaoxi> list=xiaoxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiaoxi_list2";
	}
	
	
	@RequestMapping("xxList.do")
	public String xxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiaoxi xiaoxi, String shetuanbianhao, String shetuanmingcheng, String leibie, String tongzhimingcheng, String riqi1,String riqi2, String dengjiren, String neirong){
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
		if(tongzhimingcheng==null||tongzhimingcheng.equals("")){pmap.put("tongzhimingcheng", null);}else{pmap.put("tongzhimingcheng", tongzhimingcheng);}
		if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}
		if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}
		if(dengjiren==null||dengjiren.equals("")){pmap.put("dengjiren", null);}else{pmap.put("dengjiren", dengjiren);}
		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}
		
		int total=xiaoxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiaoxi> list=xiaoxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiaoxilist";
	}
	
	@RequestMapping("deleteXiaoxi.do")
	public String deleteXiaoxi(int id,HttpServletRequest request){
		xiaoxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:xiaoxiList.do";
	}
	
	
}
