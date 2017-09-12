package com.info.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.info.model.Orders;
import com.info.model.Product;
import com.info.service.OrdersService;
import com.info.service.ProductService;
import com.info.service.ReviewService;

@Controller
@RequestMapping("/test")
public class Test {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrdersService ordersService;

	@Autowired
	ReviewService reviewService;
	
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields(new String[] {"pid"});
	//	binder.setDisallowedFields(new String[] {"cid"});
		binder.setDisallowedFields(new String[] {"rid"});
	}
	
	@RequestMapping(value="/product",  method = RequestMethod.POST)
	public ModelAndView test(@ModelAttribute("p") Product p, BindingResult rs ) {
		

		if(!rs.hasErrors()){
			productService.addProduct(p);
		}
		
		else return new ModelAndView("/admin/addNewProduct");

		
		return new ModelAndView("admin/test");
	}
	
	@RequestMapping(value="/testOrder",  method = RequestMethod.GET)
	public ModelAndView testOrder(@ModelAttribute("order1") Orders o, BindingResult rs, HttpServletRequest request ) {
		
		int pid = Integer.parseInt(request.getParameter("pid"));

		Product myProduct = productService.getProductById(pid);

		System.out.println(pid + "this is from path variable");

		return new ModelAndView("buyersDetails","myProduct", myProduct);
		

		
	}
	
	@RequestMapping(value="/addReview", method = RequestMethod.GET)
	public ModelAndView addNewCategory(HttpServletRequest request) throws IOException{

		ModelAndView mv = new ModelAndView("/customerReview");
		int id = Integer.parseInt(request.getParameter("pid"));

		Product product = new Product();

		product = productService.getProductById(id);
		System.out.println("Product Name:==========>>>>>> " + product.getPname());
		int pid = product.getPid();
		mv.addObject("pid", pid);

		return mv;

		//return new ModelAndView("/customerReview");
	}
	
	@RequestMapping(value="/orderByDate", method = RequestMethod.GET)
	public ModelAndView orderByDate(HttpServletRequest request) {
		
		String date = request.getParameter("date");
		System.out.println("Passed Date (this is form test.java): " + date);
		ModelAndView mav = new ModelAndView("/admin/orders");
		List<Orders> listOrders = ordersService.orderByDate(date);
		
		
		return new ModelAndView("/admin/orders", "listOrders", listOrders);
		
		
	}
	
}
