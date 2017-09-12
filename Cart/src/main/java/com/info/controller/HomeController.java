package com.info.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.info.model.CustomerReview;
import com.info.model.Orders;
import com.info.model.Product;
import com.info.service.CategoryService;
import com.info.service.OrdersService;
import com.info.service.ProductService;
import com.info.service.ReviewService;

@Controller
//@SessionAttributes("username")
public class HomeController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private OrdersService orderService;
	@Autowired
	private Validator ordersValidator;
	@Autowired
	private Validator reviewValidator;

	@InitBinder("order1")
	private void initBinderOrder(WebDataBinder binder) {
	
		binder.setValidator(ordersValidator);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, "date" , new CustomDateEditor(dateFormat, true));
		
	}
	
	@InitBinder("customerReview")
	private void initBinderReview(WebDataBinder binder) {
		binder.setValidator(reviewValidator);
	}

	@RequestMapping(value="")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		
		List<Product> pl = productService.getAllProducts(1, 6);
		
		return new ModelAndView("home","pl", pl);
	}

	@RequestMapping(value="/addCustomerReview", method = RequestMethod.GET)
	public ModelAndView addCustomerReview(HttpServletRequest request){

		ModelAndView mv = new ModelAndView("/productDetails");
		int id = Integer.parseInt(request.getParameter("pid"));

		Product product = new Product();

		product = productService.getProductById(id);
		System.out.println("Product Name:==========>>>>>> " + product.getPname());
		int pid = product.getPid();
		mv.addObject("pid", pid);

		return mv;

		//return new ModelAndView("/customerReview");
	}

	@RequestMapping(value="/customerReviewAdded", method = RequestMethod.POST)
	public ModelAndView customerReview(@Validated @ModelAttribute("customerReview") CustomerReview customerReview, BindingResult rs, HttpServletRequest req) {

		//reviewValidator.validate(customerReview, rs);
		
		if(!rs.hasErrors()){
			reviewService.addCustomerReview(customerReview);
			return new ModelAndView("reviewAdded");
		}
		else { 
			return addCustomerReview(req);
			//return new ModelAndView("customerReview");

		}
	}

	@RequestMapping(value="/buyersDetails", method = RequestMethod.GET)
	public ModelAndView orders(HttpServletRequest request) throws IOException{
		
		ModelAndView mv = new ModelAndView("/buyersDetails");
		int id = Integer.parseInt(request.getParameter("pid"));

		Product myProduct = new Product();

		myProduct = productService.getProductById(id);
		int pid = myProduct.getPid();
		mv.addObject("myProduct",myProduct);
		mv.addObject("pid", pid);

		return mv;
	}

	@RequestMapping(value="/makeOrder", method = RequestMethod.POST)
	public ModelAndView makeOrder(@Validated @ModelAttribute("order1") Orders order1, BindingResult rs, HttpServletRequest request) throws IOException{
		
		//ordersValidator.validate(order1, rs);

		if(!rs.hasErrors()){
			orderService.addOrder(order1);
			return new ModelAndView("makeOrder");
		}
		else { 
			
			//return "redirect:/buyersDetails/"+pid;
			return orders(request);

		}

	}

	@RequestMapping(value="/productsHome/{pageId}", method = RequestMethod.GET)
	public ModelAndView product(@PathVariable("pageId") int pageId){

		ModelAndView mv = new ModelAndView("productListHome");

		Double resultPerPage = 12.0;
		Long totalRec =  productService.getTotalProductRecs();
		int totalPages = ((Double)Math.ceil((totalRec/resultPerPage))).intValue();

		System.out.println("Total Pages: -------> " + totalPages);

		List<Product> productList = productService.getAllProducts(pageId, resultPerPage.intValue());

		mv.addObject("totalPages", totalPages);
		mv.addObject("pl", productList);

		return mv;



		/*	ProductDAOImpl pdao = new ProductDAOImpl(); // remove this line and use productService
			List<Product> productList = pdao.getAllProducts();
			for(Product p: productList) {
				System.out.println(p.getPname() + p.getCid() + "--------------" + p.getPofferprice());
			}

			return new ModelAndView("productListHome","pl", productList);*/

	}
	
	@RequestMapping(value="/productDetails/{productId}", method = RequestMethod.GET)
	public ModelAndView productDetails(@PathVariable("productId") int productId) {
		
		ModelAndView mv = new ModelAndView("productDetails");
		CustomerReview customerReview = new CustomerReview();
		Product myProduct = new Product();
		
		myProduct = productService.getProductById(productId);
		int pid = myProduct.getPid();
		List<Product> spl = productService.getSimilarProducts(1, 5, myProduct.getCid());
		
		System.out.println("this is the cid of myProduct from HOme Controller /product details---------->>>>>>" + myProduct.getCid());
		System.out.println("size of spl: ---------->>>>>" + spl.size());
		
		mv.addObject("customerReview", customerReview);
		mv.addObject("myProduct",myProduct);
		mv.addObject("spl", spl); //used for showing similar products in productDetails page
		mv.addObject("pid", pid); //used for writing review in customerReview
		
		return mv;
		
	}

}




