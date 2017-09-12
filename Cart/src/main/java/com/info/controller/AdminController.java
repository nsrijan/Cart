package com.info.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.info.model.Category;
import com.info.model.CustomerReview;
import com.info.model.Orders;
import com.info.model.Product;
import com.info.service.CategoryService;
import com.info.service.OrdersService;
import com.info.service.ProductService;
import com.info.service.ReviewService;

@Controller

@RequestMapping(value={"/admin","/admin/"})
public class AdminController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private OrdersService orderService;
	@Autowired
	private Validator productValidator;
	@Autowired
	private Validator categoryValidator;

	@InitBinder("product")
	public void initBinderProduct(WebDataBinder binder) {
		binder.setDisallowedFields("pimages");
		binder.setValidator(productValidator);
	}

	@InitBinder("category1")
	public void initBinderCategory(WebDataBinder binder) {
		binder.setValidator(categoryValidator);
	}

	@RequestMapping(value={"","/","/dashboard"})
	public ModelAndView dashboard() {

		ModelAndView mv = new ModelAndView("admin/dashboard");

		return mv;
	}

	@ModelAttribute
	public void commonMethod(Model mav){

		Long totalProduct =  productService.getTotalProductRecs();
		Long totalCateogry =  categoryService.getTotalCategoryRecs();
		Long totalOrders =  orderService.getTotalOrdersRecs();
		Long totalReview =  reviewService.getTotalReviewRecs();

		mav.addAttribute("totalProduct", totalProduct);
		mav.addAttribute("totalCateogry", totalCateogry);
		mav.addAttribute("totalOrders", totalOrders);
		mav.addAttribute("totalReview", totalReview);

	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request,HttpServletResponse response){
		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		if (auth!=null){
			new SecurityContextLogoutHandler().logout(request,response,auth);
		}

		return "redirect:/";
	}

	/*--------------------Product Stuff---------------------------*/

	//for generating categoryList for all pages
	@ModelAttribute
	public void catList(Model model) {
		model.addAttribute("cl", categoryService.listCategory());
	}

	@RequestMapping(value={"/product/{pageId}", "/product"}, method = RequestMethod.GET)
	public ModelAndView product(@PathVariable("pageId") int pageId) {

		ModelAndView mv = new ModelAndView("/admin/product");

		Double resultPerPage = 7.0;
		Long totalRec =  productService.getTotalProductRecs();
		int totalPages = ((Double)Math.ceil((totalRec/resultPerPage))).intValue();

		System.out.println("Total Pages: -------> " + totalPages);

		List<Product> productList = productService.getAllProducts(pageId, resultPerPage.intValue());

		mv.addObject("totalPages", totalPages);
		mv.addObject("pl", productList);
		//return new ModelAndView("/admin/product", "pl", productList);

		return mv;
	}



	@RequestMapping(value="/addNewProduct", method = RequestMethod.GET)
	public ModelAndView addNewProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		//List<Category> categoryList = categoryService.listCategory();

		/*for(Category cat: categoryList){
			System.out.println(cat.getCid() + "------>>>>" + cat.getCname());
		}*/

		return new ModelAndView("/admin/addNewProduct");
	}

	@RequestMapping(value="/submitNewProduct", method = RequestMethod.POST)
	public String submitNewProduct(Model model,@Validated @ModelAttribute("product") Product product, 
			@RequestParam CommonsMultipartFile pimages, HttpServletRequest request, BindingResult rs) throws Exception {

		model.addAttribute("product", product);
		//	productValidator.validate(product, rs);
		System.out.println("out of iffffffffffff");

		if(!rs.hasErrors()) {

			String path=request.getRealPath("/resources/img/products");
			String filename = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			System.out.println(path+"=========>>>>>> "+filename);        

			byte[] bytes = pimages.getBytes();  
			BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
					new File(path + File.separator + filename)));  
			System.out.println(path +"=========>>>>>> "+ File.separator +"=========>>>>>> "+ filename);        

			stream.write(bytes);  
			stream.flush();  
			stream.close();  

			product.setPimages(filename);

			productService.addProduct(product);
			return "redirect:/admin/product/1";
		}

		//else return "redirect:/admin/addNewProduct";
		else {
			List<Category> categoryList = categoryService.listCategory();
			model.addAttribute("categoryList", categoryList);
			return "admin/addNewProduct";

		}
	}

	@RequestMapping(value="/editProduct/{pid}", method = RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable("pid") int pid) {

		Product product = productService.getProductById(pid);
		List<Category> categoryList = categoryService.listCategory();
		int cid = product.getCid();

		ModelAndView mv = new ModelAndView("/admin/editProduct");
		//mv.addObject("id",pid);
		mv.addObject("cid", cid);
		mv.addObject("cl", categoryList);
		mv.addObject("pimages", product.getPimages());
		mv.addObject("product", product);		

		System.out.println(pid + " this is from path variable");

		return mv;

	}

	@RequestMapping(value="submitEditProduct", method = RequestMethod.POST)
	public String submitEditProduct(Model model,@Validated @ModelAttribute("product") Product product, 
			@RequestParam CommonsMultipartFile pimages, HttpServletRequest request, BindingResult rs) throws Exception {

		System.out.println("THIS IS FROM PRODUCT.GETiMAGES()" + product.getPimages());
		
		if(!rs.hasErrors()) {

			
				System.out.println("NAME OF PIMAGES -->>"+ pimages.getOriginalFilename() + "JAJAJAJ");
				System.out.println(" pimages is not null ");
				
				File file = new File(request.getRealPath("/resources/img/products")+ File.separator+product.getPimages());
				file.delete();
				
				String path=request.getRealPath("/resources/img/products");
				String filename = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				System.out.println(path+"=========>>>>>> "+filename); 

				byte[] bytes = pimages.getBytes();  
				BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
						new File(path + File.separator + filename)));  
				System.out.println(path +"=========>>>>>> "+ File.separator +"=========>>>>>> "+ filename);        

				stream.write(bytes);  
				stream.flush();  
				stream.close();  

				product.setPimages(filename);
			
				
			productService.updateProduct(product);
			return "redirect:/admin/product/1";
		}

		else {
			List<Category> categoryList = categoryService.listCategory();
			model.addAttribute("categoryList", categoryList);
			return "admin/editProduct";

		}
	}

	@RequestMapping(value="/deleteProduct/{pid}", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@PathVariable("pid") int pid, HttpServletRequest request) {

		Product myProduct = productService.getProductById(pid);

		String path=request.getRealPath("/resources/img/products");
		String filename = myProduct.getPimages();

		File file = new File(request.getRealPath("/resources/img/products")+ File.separator+filename);
		if(file.delete())
			System.out.println("Deleted");

		else System.out.println("not deleted");

		System.out.println(path+"=========>>>>>> "+File.separator+filename);        

		productService.deleteProduct(pid);

		System.out.println(pid + " this is from path variable");

		return product(1);

	}


	/*--------------------Categories stuff----------------------*/

	@RequestMapping(value="/category", method = RequestMethod.GET)
	public ModelAndView category() {

		List<Category> categoryList = categoryService.listCategory();

		for(Category category: categoryList){
			//cl.put(cat.getCid(), cat.getCname());
			System.out.println(category.getCid() + "------>>>>" + category.getCname());
		}

		return new ModelAndView("/admin/category", "cl", categoryList);
	}


	@RequestMapping(value="/addCategory", method = RequestMethod.GET)
	public ModelAndView addNewCategory(HttpServletResponse response) throws IOException{

		Category category1 = new Category();

		return new ModelAndView("/admin/addCategory");
	}

	@RequestMapping(value="/submitCategory", method = RequestMethod.POST)
	public ModelAndView submitCategory(@Validated @ModelAttribute("category1") Category category1 , BindingResult rs) {

		if(!rs.hasErrors()){
			categoryService.addCategory(category1);

			return category();
		}

		else return new ModelAndView("/admin/addCategory");
	}

	@RequestMapping(value="/editCategory", method = RequestMethod.GET)
	public ModelAndView editCategory(HttpServletRequest request) {

		int cid = Integer.parseInt(request.getParameter("cid"));
		Category myCategory= categoryService.getCategoryById(cid);

		ModelAndView mv = new ModelAndView("/admin/editCategory");
		mv.addObject("myCategory", myCategory);		

		System.out.println(cid + "this is from path variable");

		return mv;

	}

	@RequestMapping(value="submitEditCategory", method = RequestMethod.POST)
	public ModelAndView submitEditCategory(@ModelAttribute("category1") Category cat, BindingResult rs) {

		categoryService.updateCategory(cat);

		return category();
	}

	@RequestMapping(value="/deleteCategory", method = RequestMethod.GET)
	public ModelAndView deleteCategory(HttpServletRequest request) {

		int cid = Integer.parseInt(request.getParameter("cid"));
		categoryService.deleteCategory(cid);

		System.out.println(cid + "this is from path variable");

		return category();

	}

	/*--------------------Reviews Stuff----------------*/

	@RequestMapping(value="/reviews", method = RequestMethod.GET)
	public ModelAndView reviews(HttpServletResponse response) throws IOException{

		List<CustomerReview> listReviews = reviewService.getAllReviews();

		return new ModelAndView("/admin/reviews", "lr", listReviews);
	}


	/*--------------------Orders Stuff----------------*/

	@RequestMapping(value="/orders", method = RequestMethod.GET)
	public ModelAndView orders(HttpServletResponse response) {

		List<Orders> listOrders = orderService.getAllOrders();

		for(Orders orders: listOrders){
			System.out.println(orders.getOid() + "------>>>>" + orders.getBuyerEmail());
		}

		return new ModelAndView("/admin/orders", "listOrders", listOrders);
	}




}