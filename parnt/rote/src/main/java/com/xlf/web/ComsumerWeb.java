package com.xlf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewResolverMethodReturnValueHandler;

import com.xlf.entity.GoodsType;
import com.xlf.goods.GoodTypeService;

@Controller
public class ComsumerWeb {
	@Autowired
	private GoodTypeService gs;

	@RequestMapping("/addType")
	@ResponseBody
	public String addType(GoodsType type) {
		/*
		 * int i = gs.addType(type); System.out.println(i);
		 */
		gs.addType(type);
		System.out.println("添加成功");
		return "ok";
	}

	@RequestMapping("/index")
	public String index() {

		return "show";
	}

	@RequestMapping("/findName")
	public ModelAndView findName(String name, ModelAndView mv) {
		mv.setViewName("show");
		mv.addObject("rows", gs.findByNameString(name));
		return mv;
	}
	
	@RequestMapping("/id/{1}")
	public String id(String id) {
		
		
		
		
		return "show";
	}
	

	public GoodTypeService getGs() {
		return gs;
	}

	public void setGs(GoodTypeService gs) {
		this.gs = gs;
	}

}
