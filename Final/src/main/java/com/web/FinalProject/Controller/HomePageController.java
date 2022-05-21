package com.web.FinalProject.Controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.web.FinalProject.config.Encrypt;
import com.web.FinalProject.mapper.BrandMapper;
import com.web.FinalProject.mapper.CartMapper;
import com.web.FinalProject.mapper.CategoriesMapper;
import com.web.FinalProject.mapper.CheckoutMapper;
import com.web.FinalProject.mapper.ProductMapper;
import com.web.FinalProject.mapper.UserMapper;
import com.web.FinalProject.model.Brand;
import com.web.FinalProject.model.BrandExample;
import com.web.FinalProject.model.Cart;
import com.web.FinalProject.model.CartExample;
import com.web.FinalProject.model.Categories;
import com.web.FinalProject.model.CategoriesExample;
import com.web.FinalProject.model.Checkout;
import com.web.FinalProject.model.Product;
import com.web.FinalProject.model.ProductExample;
import com.web.FinalProject.model.User;


@Controller
public class HomePageController {
	private String SecretKey = "!@asd91!@#%";
	String [] valueItem;
	Cart cart;
	ArrayList<Object> list =  new ArrayList <Object>();
	ArrayList<Object> order =  new ArrayList <Object>();
//	ArrayList<Object> cart =  new ArrayList <Object>();
	String [] check;
	String productName;
	String priceProduct;
	String name;
	Integer quantily;
	Integer price;
	Cart cartOrder;
	Checkout checkOut;
	int total;
	
	
	
	@Autowired
	UserMapper userMapper;
	


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


		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String phone =  request.getParameter("phone");
		String username =  request.getParameter("username");
		String password =  request.getParameter("password");
		String address =  request.getParameter("address");
		String birthday =  request.getParameter("birthday");

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
			//			System.out.print(phone.length());
			modelAndView.addObject("message", "Số điện thoại từ 10 đến 11 số ");

		}else if(password.length() < 6 && password.length() > 0) {
			modelAndView.addObject("message", "Password không được dưới 6 kí tự ");

		}
		else {

			User user = new User(username,pass_bcrypt, phone, email, firstname, lastname, 1, address, birthday);
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
	public ModelAndView home(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView modelAndView =  new ModelAndView("home/index");
//		eraseCookie(response,"JSESSIONID");
		Cookie[] cookie =  request.getCookies();
		if(cookie ==  null ) {
			request.getSession(true);
		}else {
			for (Cookie c : request.getCookies()) { 
				
				if (c.getName().equals("session_idUser")) {
					if(c.getValue() != "") {
						int idUser_Decrypt =Integer.parseInt(Encrypt.decrypt(c.getValue(), SecretKey).toString());
						List<Map<String, Object>> userSession = userMapper.getUserById(idUser_Decrypt);
						modelAndView.addObject("dataUser",userSession);
//						System.out.print(userSession);
						modelAndView.addObject("checkSessionUser",userSession.size());
						
					
						
						

					}else {
						modelAndView.addObject("checkSessionUser",0);

						
					
					}
				
				}
			}

		}
		CategoriesExample categoriesExample =  new CategoriesExample();
//		System.out.print(Encrypt.decrypt("//F43Kra7ILQFERDr+P9SQ==", "@1aanhasA1!%&n"));
		//		System.out.println(Encrypt.encrypt("123456", "@1aanhasA1!%&n"));
		List<Categories> listCategory =  categoriesMapper.selectByExample(categoriesExample);

		BrandExample brandExample =  new BrandExample();


		List<Brand> listBrand =  brandMapper.selectByExample(brandExample);

		if(cookie ==  null ) {
			request.getSession(true);
		}else {
			for (Cookie c : request.getCookies()) { 
				
				if (c.getName().equals("session_idUser")) {
					if(c.getValue() != "") {
					String UserName_Decrypt = Encrypt.decrypt(c.getValue(), SecretKey);
//					System.out.print(UserName_Decrypt);

					//System.out.print(UserName_Decrypt);
					List<Map<String, Object>> listUser =  userMapper.getUserById(Integer.parseInt(UserName_Decrypt));
					modelAndView.addObject("nameUser", listUser);

//					for(Map<String, Object> value: listUser){
//						modelAndView.addObject("nameUser", value);
//					}
//					System.out.print(listUser.size());
					if(listUser.size() > 0) {
						modelAndView.addObject("checkUser", listUser.size());
							
					}

				}else {
					modelAndView.addObject("checkUser", 0);

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
	public ModelAndView shop(HttpServletRequest request ) {
		ModelAndView modelAndView =  new ModelAndView("home/shop");

		
		
		CategoriesExample example =  new CategoriesExample();

		
		






		Cookie[] cookie =  request.getCookies();
			if(cookie ==  null ) {
				request.getSession(true);
			}else {
				for (Cookie c : request.getCookies()) { 
					
					if (c.getName().equals("session_idUser")) {
						if(c.getValue() != "") {
							int idUser_Decrypt =Integer.parseInt(Encrypt.decrypt(c.getValue(), SecretKey).toString());
							List<Map<String, Object>> userSession = userMapper.getUserById(idUser_Decrypt);
							modelAndView.addObject("dataUser",userSession);
//							System.out.print(userSession);
							modelAndView.addObject("checkSessionUser",userSession.size());
							
						
							
							

						}else {
							modelAndView.addObject("checkSessionUser",0);

							
						
						}
					
					}
				}

			}
		List<Categories> listCategory =  categoriesMapper.selectByExample(example);

		modelAndView.addObject("listCategory",listCategory); 	


		return modelAndView;

	}
	

	   static int[] method(String str)
	    {
	 
	        String[] splitArray = str.split(" ");
	        int[] array = new int[splitArray.length];
	 
	        // parsing the String argument as a signed decimal
	        // integer object and storing that integer into the
	        // array
	        for (int i = 0; i < splitArray.length; i++) {
	            array[i] = Integer.parseInt(splitArray[i]);
	        }
	        return array;
	    }


		@Autowired
		CartMapper cartMapper;
		static String getSession(HttpServletRequest request) {
			Cookie[] cookie =  request.getCookies();
			String user="";
			String Secret = "!@asd91!@#%";

			for (Cookie c : cookie) { 

				if (c.getName().equals("session_idUser")) {
					 user = Encrypt.decrypt(c.getValue(), Secret);
					user = user.toString();
					 
				}
			}
			return  user;
		}

		
		
	@GetMapping("/removecart/{id}")
	public ModelAndView removeItemCart(@PathVariable int id) {
		
		ModelAndView modelAndView =  new ModelAndView("home/cart");
		cartMapper.deleteByPrimaryKey(id);

		
		return modelAndView;
	}
	
	@GetMapping("/data/{data}")
	public ModelAndView checkCartdb(@PathVariable Object data,HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView modelAndView =  new ModelAndView("home/cart");
//		System.out.print(data);
		return modelAndView;
	}
	
	
	@GetMapping("/cart")
	public  ModelAndView cart(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView modelAndView =  new ModelAndView("home/cart");

		Cookie[] cookie =  request.getCookies();
			if(cookie ==  null ) {
				request.getSession(true);
			}else {
				for (Cookie c : request.getCookies()) { 
					
					if (c.getName().equals("session_idUser")) {
						if(c.getValue() != "") {
							int idUser_Decrypt =Integer.parseInt(Encrypt.decrypt(c.getValue(), SecretKey).toString());
							List<Map<String, Object>> userSession = userMapper.getUserById(idUser_Decrypt);
							modelAndView.addObject("dataUser",userSession);
//							System.out.print(userSession);
							modelAndView.addObject("checkSessionUser",userSession.size());
							
						
							
							

						}else {
							modelAndView.addObject("checkSessionUser",0);

							
						
						}
					
					}
				}

			}

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		Map<String, Object> param =  new HashMap<>();
		Map<String, Object> list =  new HashMap<>();

		for (Cookie c : request.getCookies()) { 
			
			if (c.getName().equals("cart")) {
				
				
					if(c.getValue() =="") {
						return modelAndView;

					}else {
						String [] listProduct =  (c.getValue()).split("=");
						for(int x =0;  x < listProduct.length;  x++) {
							String [] listItem =  listProduct[x].split("'");
							for(int u = 0;  u < listItem.length; u++) {
								int total =  Integer.parseInt(listItem[3]) * Integer.parseInt(listItem[2]);

								cart =  new Cart(
										Integer.parseInt(listItem[0]),
										Integer.parseInt(listItem[2]),
										listItem[1].toString(),
										Integer.parseInt(getSession(request)),
										listItem[4].toString(),
										total,
										0, 
										date				
										);
										
//								System.out.println(listItem[u]);
								param.put("userID",Integer.parseInt(getSession(request)));
								param.put("sucess",0);
								param.put("product_id",Integer.parseInt(listItem[0]));
							
						
							}
							List<Map<String, Object>> checkProductInCart =  cartMapper.selectCheckCart(param);
							if(checkProductInCart.size() == 0) {
								 cartMapper.insert(cart);
								 

								 
							
							}
							

						}
						
						
						
					}
					list.put("idUser",Integer.parseInt(getSession(request)));
					list.put("sucess",0);
				
					List<Map<String, Object>> listProductShowCart=  cartMapper.selectProductCart(list);
					System.out.println(listProductShowCart);
					if(listProductShowCart.size() > 0) {
						modelAndView.addObject("listProductCart",listProductShowCart);

					}else {
						modelAndView.addObject("listProductCart","");

					}
				}
			
			
	

		
//			
//			List<Map<String, Object>> listProductShowCart=  cartMapper.selectProductCart(list);
//			modelAndView.addObject("listProductCart",listProductShowCart);
////			System.out.println(listProductShowCart);

	}
				
				
				
		return modelAndView;

		

	}

	private void eraseCookie(HttpServletResponse response, String key) {
		Cookie valueCookie = new Cookie(key, null);
		valueCookie.setMaxAge(0);
		valueCookie.setSecure(true);	
		valueCookie.setHttpOnly(true);
		valueCookie.setPath("/");
		response.addCookie(valueCookie);
	}

	@Autowired
	CheckoutMapper checkoutMapper;
	@GetMapping("/checkout")
	public ModelAndView checkout(HttpServletResponse response,HttpServletRequest request) {
		
		ModelAndView modelAndView =  new ModelAndView("home/checkout");

		 eraseCookie(response,"cart");

		 int id =  Integer.parseInt(getSession(request));
			Cookie[] cookie =  request.getCookies();
			if(cookie ==  null ) {
				request.getSession(true);
			}else {
				for (Cookie c : request.getCookies()) { 
					
					if (c.getName().equals("session_idUser")) {
						if(c.getValue() != "") {
							int idUser_Decrypt =Integer.parseInt(Encrypt.decrypt(c.getValue(), SecretKey).toString());
							List<Map<String, Object>> userSession = userMapper.getUserById(idUser_Decrypt);
							modelAndView.addObject("dataUser",userSession);
//							System.out.print(userSession);
							System.out.print(userSession);
							modelAndView.addObject("checkSessionUser",userSession.size());
							
						
							
							

						}else {
							modelAndView.addObject("checkSessionUser",0);

							
						
						}
					
					}
				}

			}



		Map<String, Object> param =  new HashMap<>();
		

		param.put("userID", id);
		param.put("sucess", 0);
		
		List<Map<String, Object>> ItemCart =  cartMapper.selectItemInsertCheckout(param);
			if(ItemCart.size() > 0) {
				for(Map<String, Object> value: ItemCart) {
					if(value != null) {
						 total  =  Integer.parseInt(value.get("TotalItem").toString());

					}
					
				}
			}
	
		List<Map<String, Object>> check =  checkoutMapper.checkExist(Integer.parseInt(getSession(request).toString()));
		 checkOut =  new Checkout(total, Integer.parseInt(getSession(request).toString()), 0);
		 
		 if(check.size() <= 0) {
				checkoutMapper.insert(checkOut);

		 }

		
		
		
		
		CategoriesExample example =  new CategoriesExample();
		List<Categories> listCategory =  categoriesMapper.selectByExample(example);

		modelAndView.addObject("listCategory",listCategory); 	
		return modelAndView;

	}
	@PostMapping("/checkout")
	public ModelAndView checkOutProcess() {
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
	
	
	@GetMapping("/confirm")
	public ModelAndView comfirm(HttpServletRequest request) {
		ModelAndView modelAndView =  new ModelAndView("home/confirm");
		Map<String, Object> param =  new HashMap<>();
		Map<String, Object> result =  new HashMap<>();
		Map<String, Object> data =  new HashMap<>();
		Map<String, Object> valueInput =  new HashMap<>();

		
		param.put("userID", Integer.parseInt(getSession(request).toString()));
		param.put("sucess", 0);
		
				List<Map<String, Object>> listCart = cartMapper.selectItemInsertCheckout(param);
					for(Map<String, Object> valueItem: listCart) {
					
//							cartMapper.updateCart(Integer.parseInt(data.get("id").toString()));
							result.put("id_user", (Integer.parseInt(getSession(request).toString())));
							
							
							List<Map<String, Object>> listcheck  = checkoutMapper.checkIdCart(result);
							for(Map<String,Object> value: listcheck) {
								List<Map<String, Object>> insertCart = cartMapper.InsertIdCartInCheckout(Integer.parseInt(getSession(request)));
								for(Map<String, Object> item: insertCart ) {
									data.put("id_checkout", item.get("CheckoutId"));
									data.put("id", item.get("CartId"));
									

									System.out.print(item);
									cartMapper.updateCartCheckOut(data);
									
									valueInput.put("id", Integer.parseInt(data.get("id").toString()));
									valueInput.put("id_user", Integer.parseInt(getSession(request)));

									cartMapper.updateCart(valueInput);
//

								}
							
							}

							
					}
					checkoutMapper.updateActiveCart(Integer.parseInt(getSession(request).toString()));
		
		return modelAndView;

	}

	@Autowired
	ProductMapper productMapper;
	@GetMapping("/categories/{id}")
	public ModelAndView detailCategories(@PathVariable int id) {
		ModelAndView modelAndView =  new ModelAndView("home/shopCategories");

		List<Map<String, Object>> listShopCategory = productMapper.getProductByCategory(id);

		modelAndView.addObject("listShopCategory",listShopCategory);
//		System.out.println(listShopCategory);

		return modelAndView;

	}




	@GetMapping("/detailProduct/{id}")
	public ModelAndView detailProduct(@PathVariable int id, HttpServletRequest request) {

		ModelAndView modelAndView =  new ModelAndView("home/detail");


		Cookie[] cookie =  request.getCookies();
			if(cookie ==  null ) {
				request.getSession(true);
			}else {
				for (Cookie c : request.getCookies()) { 
					
					if (c.getName().equals("session_idUser")) {
						if(c.getValue() != "") {
							int idUser_Decrypt =Integer.parseInt(Encrypt.decrypt(c.getValue(), SecretKey).toString());
							List<Map<String, Object>> userSession = userMapper.getUserById(idUser_Decrypt);
							modelAndView.addObject("dataUser",userSession);
//							System.out.print(userSession);
							modelAndView.addObject("checkSessionUser",userSession.size());
							
						
							
							

						}else {
							modelAndView.addObject("checkSessionUser",0);

							
						
						}
					
					}
				}

			}
		ProductExample productExample =  new ProductExample();
		Product productDetail =  productMapper.selectByPrimaryKey(id);
		
		
		
		modelAndView.addObject("productDetail", productDetail);


		return modelAndView;

	}

	@GetMapping("/collection/{brandName}")
	public ModelAndView listProductByBrand(@PathVariable String brandName, HttpServletRequest request) {
		ModelAndView modelAndView =  new ModelAndView("home/shopBrand");

		CategoriesExample  categoriesExample  = new CategoriesExample();
		BrandExample brandExample =  new BrandExample();
		
		List<Brand> listBrand =  brandMapper.selectByExample(brandExample);

		List<Categories> listCategories =  categoriesMapper.selectByExample(categoriesExample);
		List<Map<String, Object>> idBrand =  brandMapper.getIdBrandName(brandName);
		
		Cookie[] cookie =  request.getCookies();
		if(cookie ==  null ) {
			request.getSession(true);
		}else {
			for (Cookie c : request.getCookies()) { 
				
				if (c.getName().equals("session_idUser")) {
					if(c.getValue() != "") {
						int idUser_Decrypt =Integer.parseInt(Encrypt.decrypt(c.getValue(), SecretKey).toString());
						List<Map<String, Object>> userSession = userMapper.getUserById(idUser_Decrypt);
						modelAndView.addObject("dataUser",userSession);
//						System.out.print(userSession);
						modelAndView.addObject("checkSessionUser",userSession.size());
						
					
						
						

					}else {
						modelAndView.addObject("checkSessionUser",0);

						
					
					}
				
				}
			}

		}
		int tmp = (int) idBrand.get(0).get("id_brand");
		//		System.out.print(tmp);
		List<Map<String, Object>> listProductBrand = productMapper.getProductByBrand(tmp);
		modelAndView.addObject("listProductBrand", listProductBrand);
		modelAndView.addObject("listCategory",listCategories);
		modelAndView.addObject("listBrand",listBrand);

		return modelAndView;

	}


}
