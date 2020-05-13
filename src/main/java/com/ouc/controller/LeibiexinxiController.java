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

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ouc.entity.Leibiexinxi;
import com.ouc.server.LeibiexinxiServer;
import com.ouc.util.PageBean;
import net.sf.json.JSONObject;

import java.sql.SQLException;

@Controller
public class LeibiexinxiController {
	@Resource
	private LeibiexinxiServer leibiexinxiService;


   
	@RequestMapping("addLeibiexinxi.do")
	public String addLeibiexinxi(HttpServletRequest request,Leibiexinxi leibiexinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		leibiexinxi.setAddtime(time.toString().substring(0, 19));
		leibiexinxiService.add(leibiexinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "leibiexinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:leibiexinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateLeibiexinxi.do")
	public String doUpdateLeibiexinxi(int id,ModelMap map,Leibiexinxi leibiexinxi){
		leibiexinxi=leibiexinxiService.getById(id);
		map.put("leibiexinxi", leibiexinxi);
		return "leibiexinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("leibiexinxiDetail.do")
	public String leibiexinxiDetail(int id,ModelMap map,Leibiexinxi leibiexinxi){
		leibiexinxi=leibiexinxiService.getById(id);
		map.put("leibiexinxi", leibiexinxi);
		return "leibiexinxi_detail";
	}
//	前台详细
	@RequestMapping("lbxxDetail.do")
	public String lbxxDetail(int id,ModelMap map,Leibiexinxi leibiexinxi){
		leibiexinxi=leibiexinxiService.getById(id);
		map.put("leibiexinxi", leibiexinxi);
		return "leibiexinxidetail";
	}
//	
	@RequestMapping("updateLeibiexinxi.do")
	public String updateLeibiexinxi(int id,ModelMap map,Leibiexinxi leibiexinxi,HttpServletRequest request,HttpSession session){
		leibiexinxiService.update(leibiexinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:leibiexinxiList.do";
	}

//	分页查询
	@RequestMapping("leibiexinxiList.do")
	public String leibiexinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Leibiexinxi leibiexinxi, String leibie, String shuoming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shuoming==null||shuoming.equals("")){pmap.put("shuoming", null);}else{pmap.put("shuoming", shuoming);}
		
		int total=leibiexinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Leibiexinxi> list=leibiexinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "leibiexinxi_list";
	}
	
	
	
	@RequestMapping("lbxxList.do")
	public String lbxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Leibiexinxi leibiexinxi, String leibie, String shuoming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shuoming==null||shuoming.equals("")){pmap.put("shuoming", null);}else{pmap.put("shuoming", shuoming);}
		
		int total=leibiexinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Leibiexinxi> list=leibiexinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "leibiexinxilist";
	}
	
	@RequestMapping("deleteLeibiexinxi.do")
	public String deleteLeibiexinxi(int id,HttpServletRequest request){
		leibiexinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:leibiexinxiList.do";
	}
	
	@RequestMapping("quchongLeibiexinxi.do")
	public void quchongLeibiexinxi(Leibiexinxi leibiexinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("leibie", leibiexinxi.getLeibie());
		   System.out.println("leibie==="+leibiexinxi.getLeibie());
		   System.out.println("leibie222==="+leibiexinxiService.quchongLeibiexinxi(map));
		   JSONObject obj=new JSONObject();
		   if(leibiexinxiService.quchongLeibiexinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "类别可以用！");
				  
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
