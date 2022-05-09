package com.web.FinalProject.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.FinalProject.config.Encrypt;
import com.web.FinalProject.mapper.BrandMapper;
import com.web.FinalProject.mapper.CategoriesMapper;
import com.web.FinalProject.mapper.ProductMapper;
import com.web.FinalProject.mapper.UserMapper;
import com.web.FinalProject.model.Brand;
import com.web.FinalProject.model.BrandExample;
import com.web.FinalProject.model.Categories;
import com.web.FinalProject.model.CategoriesExample;
import com.web.FinalProject.model.Product;
import com.web.FinalProject.model.ProductExample;
import com.web.FinalProject.model.User;


@Controller
public class HomePageController {
	private String SecretKey = "1@1231%&$$!";

	@Autowired
	UserMapper userMapper;

	@PreAuthorize("hasAuthority('USER')")

	@GetMapping("/login")
	public String login() {

//		System.out.print(cookies);
//		String valueUserName =  Encrypt.decrypt(null, null)
		  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		  
	        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
	        	
	            return "login/index";
	        }
	        return "redirect:/";
	}
	
	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView("login/register");
		return modelAndView;
	}

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/process_register")
	
	public ModelAndView process_register(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("login/register");
		

		String phone =  request.getParameter("phone");
		String username =  request.getParameter("username");
		String password =  request.getParameter("password");
		String re_password =  request.getParameter("re_password");
		String email =  request.getParameter("email");
		String pass_bcrypt  = passwordEncoder.encode(password);
		List<Map<String, Object>> checkEmail =  userMapper.checkEmailUser(email);
		List<Map<String, Object>> checkPhone =  userMapper.checkPhoneUser(phone);

		if(!password.equals(re_password)) {
			modelAndView.addObject("message", "Mật khẩu không khớp! Vui lòng nhập lại");

		}else if(checkEmail.size()  > 0) {
			modelAndView.addObject("message", "Email đã được đăng kí vui lòng nhập email khác");

			
		}else if(checkPhone.size() > 0) {
			modelAndView.addObject("message", "Số điện thoại đã được đăng kí");

		}else if(phone.length() < 10 && phone.length() > 11) {
			System.out.print(phone.length());
			modelAndView.addObject("message", "Số điện thoại từ 10 đến 11 số ");

		}else if(password.length() < 6 && password.length() > 0) {
			modelAndView.addObject("message", "Password không được dưới 6 kí tự ");

		}
		else {

			User user = new User(username,pass_bcrypt,1, phone, email);
			userMapper.insert(user);
			modelAndView.addObject("message", "Đăng kí thành công ");

		}




		
		return modelAndView;
	}
	@GetMapping("/process_register")
	
	public ModelAndView process_register() {
		ModelAndView modelAndView = new ModelAndView("login/register");
		

		
		
		return modelAndView;
	}
	
	
	@Autowired
	CategoriesMapper categoriesMapper;
	@Autowired
	BrandMapper brandMapper;
	
	@GetMapping("/")
	public ModelAndView home(HttpServletRequest request) {
		ModelAndView modelAndView =  new ModelAndView("home/index");

		CategoriesExample categoriesExample =  new CategoriesExample();


		List<Categories> listCategory =  categoriesMapper.selectByExample(categoriesExample);

		BrandExample brandExample =  new BrandExample();


		List<Brand> listBrand =  brandMapper.selectByExample(brandExample);
		
			Cookie[] cookie =  request.getCookies();
			if(cookie ==  null ) {
					 request.getSession(true);
			}else {
				 for (Cookie c : request.getCookies()) { 
						
					  if (c.getName().equals("session_idUser")) {
			          	 String UserName_Decrypt = Encrypt.decrypt(c.getValue(), SecretKey);
			          	 System.out.print(UserName_Decrypt);
			          	 List<Map<String, Object>> listUser =  userMapper.getUserByName(UserName_Decrypt);
			          	 for(Map<String, Object> value: listUser){
			          		 modelAndView.addObject("nameUser", value);
			          	 }
			            }
					}
			
			}
			
		 
		
		
		
		modelAndView.addObject("listCategory",listCategory); 

		modelAndView.addObject("listbrand",listBrand); 	
		
//	    String sessionId = session.setAttribute("", listBrand)  
//	    System.out.print(sessionId);

	    
		return modelAndView;

	}
	
	@GetMapping("/logout")
	public String Logout(HttpServletResponse response,HttpServletRequest request ) {
		Cookie cookie = new Cookie("JSESSIONID", null);
		Cookie username = new Cookie("session_idUser", null);
		cookie.setMaxAge(0);
		cookie.setSecure(true);
		cookie.setHttpOnly(true);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		response.addCookie(username);

	

		
		return "redirect:/";

	}
	


	@GetMapping("/shop")
	public ModelAndView shop() {
		ModelAndView modelAndView =  new ModelAndView("home/shop");

		CategoriesExample example =  new CategoriesExample();

		List<Categories> listCategory =  categoriesMapper.selectByExample(example);

		modelAndView.addObject("listCategory",listCategory); 	


		return modelAndView;

	}
	@GetMapping("/cart")
	public ModelAndView cart() {
		ModelAndView modelAndView =  new ModelAndView("home/cart");

		CategoriesExample example =  new CategoriesExample();

		List<Categories> listCategory =  categoriesMapper.selectByExample(example);
		modelAndView.addObject("listCategory",listCategory); 	


		return modelAndView;

	}

	@GetMapping("/checkout")
	public ModelAndView checkout() {
		ModelAndView modelAndView =  new ModelAndView("home/checkout");
		CategoriesExample example =  new CategoriesExample();
		List<Categories> listCategory =  categoriesMapper.selectByExample(example);
		
		modelAndView.addObject("listCategory",listCategory); 	
		return modelAndView;

	}
	@GetMapping("/contact")
	public ModelAndView contact() {
		ModelAndView modelAndView =  new ModelAndView("home/contact");
		return modelAndView;

	}
	
	@Autowired
	ProductMapper productMapper;
	@GetMapping("/categories/{id}")
	public ModelAndView detailCategories(@PathVariable int id) {
		ModelAndView modelAndView =  new ModelAndView("home/shopCategories");
		
		List<Map<String, Object>> listShopCategory = productMapper.getProductByCategory(id);
		
		 modelAndView.addObject("listShopCategory",listShopCategory);
		 for(Map<String, Object> value: listShopCategory) {
			 System.out.print(value.get("product_name"));
		 }
		
		return modelAndView;

	}
	
	
	

	@GetMapping("/detailProduct/{id}")
	public ModelAndView detailProduct(@PathVariable int id) {
		ModelAndView modelAndView =  new ModelAndView("home/detail");
		
//		List<Map<String, Object>> listShopCategory = productMapper.getProduct(id);
//		
//		 modelAndView.addObject("listShopCategory",listShopCategory);
//		 for(Map<String, Object> value: listShopCategory) {
//			 System.out.print(value.get("product_name"));
//		 }
		ProductExample productExample =  new ProductExample();
		Product productDetail =  productMapper.selectByPrimaryKey(id);
		modelAndView.addObject("productDetail", productDetail);
		
		
		return modelAndView;

	}
	
	@GetMapping("/collection/{brandName}")
	public ModelAndView listProductByBrand(@PathVariable String brandName) {
		ModelAndView modelAndView =  new ModelAndView("home/shopBrand");
		
		CategoriesExample  categoriesExample  = new CategoriesExample();
		
		List<Categories> listCategories =  categoriesMapper.selectByExample(categoriesExample);
		List<Map<String, Object>> idBrand =  brandMapper.getIdBrandName(brandName);
		

		int tmp = (int) idBrand.get(0).get("id_brand");
		System.out.print(tmp);
		List<Map<String, Object>> listProductBrand = productMapper.getProductByBrand(tmp);
		modelAndView.addObject("listProductBrand", listProductBrand);
		modelAndView.addObject("listCategory",listCategories);
		return modelAndView;
		
	}

	
}
