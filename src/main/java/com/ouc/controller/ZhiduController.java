package com.ouc.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ouc.entity.Zhidu;
import com.ouc.server.ZhiduServer;
import com.ouc.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class ZhiduController {
	@Resource
	private ZhiduServer zhiduService;


   
	@RequestMapping("addZhidu.do")
	public String addZhidu(HttpServletRequest request, Zhidu zhidu, HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		zhidu.setAddtime(time.toString().substring(0, 19));
		zhiduService.add(zhidu);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		//session.setAttribute("backurl", "zhiduList.do");
		return "redirect:postback.jsp";
		//return "redirect:zhiduList.do";
	}
 
//	处理编辑
	@RequestMapping("doUpdateZhidu.do")
	public String doUpdateZhidu(int id,ModelMap map,Zhidu zhidu){
		zhidu=zhiduService.getById(id);
		map.put("zhidu", zhidu);
		return "zhidu_updt";
	}
//	后台详细
	@RequestMapping("zhiduDetail.do")
	public String zhiduDetail(int id,ModelMap map,Zhidu zhidu){
		zhidu=zhiduService.getById(id);
		map.put("zhidu", zhidu);
		return "zhidu_detail";
	}
//	前台详细
	@RequestMapping("zdDetail.do")
	public String zdDetail(int id,ModelMap map,Zhidu zhidu){
		zhidu=zhiduService.getById(id);
		map.put("zhidu", zhidu);
		return "zhidudetail";
	}
//	
	@RequestMapping("updateZhidu.do")
	public String updateZhidu(int id,ModelMap map,Zhidu zhidu,HttpServletRequest request,HttpSession session){
		zhiduService.update(zhidu);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:zhiduList.do";
	}

//	分页查询
	@RequestMapping("zhiduList.do")
	public String zhiduList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhidu zhidu, String shetuanbianhao, String shetuanmingcheng, String leibie, String zhangjie, String zhidumingcheng, String zhiduneirong, String dengjiren){
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
		if(zhangjie==null||zhangjie.equals("")){pmap.put("zhangjie", null);}else{pmap.put("zhangjie", zhangjie);}
		if(zhidumingcheng==null||zhidumingcheng.equals("")){pmap.put("zhidumingcheng", null);}else{pmap.put("zhidumingcheng", zhidumingcheng);}
		if(zhiduneirong==null||zhiduneirong.equals("")){pmap.put("zhiduneirong", null);}else{pmap.put("zhiduneirong", zhiduneirong);}
		if(dengjiren==null||dengjiren.equals("")){pmap.put("dengjiren", null);}else{pmap.put("dengjiren", dengjiren);}
		
		int total=zhiduService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhidu> list=zhiduService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhidu_list";
	}
	
	@RequestMapping("zhiduList2.do")
	public String zhiduList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhidu zhidu, String shetuanbianhao, String shetuanmingcheng, String leibie, String zhangjie, String zhidumingcheng, String zhiduneirong, String dengjiren,HttpServletRequest request){
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
		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(zhangjie==null||zhangjie.equals("")){pmap.put("zhangjie", null);}else{pmap.put("zhangjie", zhangjie);}
		if(zhidumingcheng==null||zhidumingcheng.equals("")){pmap.put("zhidumingcheng", null);}else{pmap.put("zhidumingcheng", zhidumingcheng);}
		if(zhiduneirong==null||zhiduneirong.equals("")){pmap.put("zhiduneirong", null);}else{pmap.put("zhiduneirong", zhiduneirong);}
		
		
		int total=zhiduService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhidu> list=zhiduService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhidu_list2";
	}
	
	
	@RequestMapping("zdList.do")
	public String zdList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhidu zhidu, String shetuanbianhao, String shetuanmingcheng, String leibie, String zhangjie, String zhidumingcheng, String zhiduneirong, String dengjiren){
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
		if(zhangjie==null||zhangjie.equals("")){pmap.put("zhangjie", null);}else{pmap.put("zhangjie", zhangjie);}
		if(zhidumingcheng==null||zhidumingcheng.equals("")){pmap.put("zhidumingcheng", null);}else{pmap.put("zhidumingcheng", zhidumingcheng);}
		if(zhiduneirong==null||zhiduneirong.equals("")){pmap.put("zhiduneirong", null);}else{pmap.put("zhiduneirong", zhiduneirong);}
		if(dengjiren==null||dengjiren.equals("")){pmap.put("dengjiren", null);}else{pmap.put("dengjiren", dengjiren);}
		
		int total=zhiduService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhidu> list=zhiduService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhidulist";
	}
	
	@RequestMapping("deleteZhidu.do")
	public String deleteZhidu(int id,HttpServletRequest request){
		zhiduService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:zhiduList.do";
	}
	
	
}
