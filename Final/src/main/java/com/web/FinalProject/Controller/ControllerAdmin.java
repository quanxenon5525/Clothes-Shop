package com.web.FinalProject.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.FinalProject.mapper.BrandMapper;
import com.web.FinalProject.mapper.CartMapper;
import com.web.FinalProject.mapper.CategoriesMapper;
import com.web.FinalProject.mapper.CheckoutMapper;
import com.web.FinalProject.mapper.ProductMapper;
import com.web.FinalProject.model.Brand;
import com.web.FinalProject.model.BrandExample;
import com.web.FinalProject.model.Categories;
import com.web.FinalProject.model.CategoriesExample;
import com.web.FinalProject.model.Product;
import com.web.FinalProject.model.ProductExample;
@Controller
public class ControllerAdmin {
	
	@Autowired
	BrandMapper brandMapper;
	@Autowired
	CategoriesMapper categoriesMapper;
	@Autowired
	ProductMapper productMapper;
	@GetMapping("/admin")
	
	public ModelAndView index() {
		ModelAndView modelAndView =  new ModelAndView("admin/index");
		return modelAndView;
	}
	//manager product
	@GetMapping("/ManagerProduct/AddProduct")
	public ModelAndView addProduct() {
		
		ModelAndView modelAndView =  new ModelAndView("admin/ManagerProduct/AddProduct");
		CategoriesExample categorieExample =  new CategoriesExample();
		List<Categories> listCategories =  categoriesMapper.selectByExample(categorieExample);
		BrandExample brandExample =  new BrandExample();
		List<Brand> listBrand =  brandMapper.selectByExample(brandExample);
		modelAndView.addObject("listBrand",listBrand);
		modelAndView.addObject("listCategories",listCategories);


		
		
		
		return modelAndView;
	}
	@GetMapping("/ManagerProduct/EditProduct/{id}")
	public ModelAndView EditProduct(@PathVariable Integer id) {
		
		ModelAndView modelAndView =  new ModelAndView("admin/ManagerProduct/EditProduct");
		CategoriesExample categorieExample =  new CategoriesExample();
		List<Categories> listCategories =  categoriesMapper.selectByExample(categorieExample);
		BrandExample brandExample =  new BrandExample();
		List<Brand> listBrand =  brandMapper.selectByExample(brandExample);
		modelAndView.addObject("listBrand",listBrand);
		modelAndView.addObject("listCategories",listCategories);

		List<Map<String, Object>> productDetail =  productMapper.selectAllProductUpdate(id);
		
		modelAndView.addObject("productDetail",productDetail);

		
		
		
		return modelAndView;
	}
	@PostMapping("/ManagerProduct/EditProduct")
	public ModelAndView EditProductProcess(HttpServletRequest request) {
		ModelAndView modelAndView =  new ModelAndView("admin/ManagerProduct/AddProduct");
		String Nameproduct =  request.getParameter("Nameproduct");
		String Priceproduct =  request.getParameter("Priceproduct");
		String img =  request.getParameter("img");
		String productDecribe =  request.getParameter("productDecribe");
		String productCategory =  request.getParameter("productCategory");
		String productBrand =  request.getParameter("productBrand");
		String active =  request.getParameter("active");
		String color =  request.getParameter("colorProduct");
		String id =  request.getParameter("idproduct");



		List<Map<String, Object>> check = productMapper.checkProduct(Nameproduct.toString());

		if(check.size() > 1) {
			modelAndView.addObject("message","Tên Sản phẩm đã tồn tại");

		}else {
			Product product =  new Product(
					Integer.parseInt(id),
					Nameproduct,
					Integer.parseInt(Priceproduct),
					Integer.parseInt(productBrand), 
					Integer.parseInt(productCategory),
					Integer.parseInt(active),
					color,
					img,
					productDecribe
					);
			productMapper.updateByPrimaryKeySelective(product);
			modelAndView.addObject("message","Cập nhật sản phẩm thành công");

		}
		return modelAndView;
	}
	
	
	@PostMapping("/ManagerProduct/AddProduct")
	public ModelAndView ProcessAddProduct(HttpServletRequest request) {
		ModelAndView modelAndView =  new ModelAndView("admin/ManagerProduct/AddProduct");
		String Nameproduct =  request.getParameter("Nameproduct");
		String Priceproduct =  request.getParameter("Priceproduct");
		String img =  request.getParameter("img");
		String productDecribe =  request.getParameter("productDecribe");
		String productCategory =  request.getParameter("productCategory");
		String productBrand =  request.getParameter("productBrand");
		String active =  request.getParameter("active");
		String color =  request.getParameter("colorProduct");


		System.out.println(Nameproduct);
		System.out.println(Priceproduct);
		System.out.println(img);
		System.out.println(productDecribe);
		System.out.println(productCategory);
		System.out.println(productBrand);
		System.out.println(active);
		List<Map<String, Object>> check = productMapper.checkProduct(Nameproduct.toString());

		if(check.size() > 0) {
			modelAndView.addObject("message","Tên Sản phẩm đã tồn tại");

		}else {
			Product product =  new Product(
					Nameproduct,
					Integer.parseInt(Priceproduct),
					Integer.parseInt(productBrand), 
					Integer.parseInt(productCategory),
					Integer.parseInt(active),
					color,
					img,
					productDecribe
					);
			productMapper.insert(product);
			modelAndView.addObject("message","Thêm sản phẩm thành công");

		}
		return modelAndView;
	}
	@GetMapping("/ManagerProduct/ListProduct")
	public ModelAndView ListProduct() {
		ModelAndView modelAndView =  new ModelAndView("admin/ManagerProduct/ListProduct");
//		ProductExample productExample =  new ProductExample();
		List<Map<String, Object>> listProduct =  productMapper.selectAllProduct();
		
		modelAndView.addObject("listProduct",listProduct);

		return modelAndView;
	}
	@GetMapping("/ManagerProduct/removeProduct/{id}")
	public ModelAndView removeProduct(@PathVariable Integer id) {
		ModelAndView modelAndView =  new ModelAndView("admin/ManagerProduct/ListProduct");
//		ProductExample productExample =  new ProductExample();
		productMapper.deleteByPrimaryKey(id);
		

		return modelAndView;
	}
	
	//manager brand

	@GetMapping("/ManagerBrand/AddBrand")
	public ModelAndView addBrand() {
		ModelAndView modelAndView =  new ModelAndView("admin/ManagerBrand/AddBrand");
				return modelAndView;
	}
	@GetMapping("/ManagerBrand/ListBrand")
	public ModelAndView ListBrand() {
		ModelAndView modelAndView =  new ModelAndView("admin/ManagerBrand/ListBrand");
		BrandExample brandExample  =  new BrandExample();
		List<Brand> listBrand = brandMapper.selectByExample(brandExample);
		modelAndView.addObject("listBrand",listBrand);
		return modelAndView;
	}
	@GetMapping("/ManagerBrand/removeBrand/{id}")
	public ModelAndView removeBrand(@PathVariable Integer id) {
		ModelAndView modelAndView =  new ModelAndView("admin/ManagerBrand/ListBrand");
		brandMapper.deleteByPrimaryKey(id);
		
		return modelAndView;
	}
	@GetMapping("/ManagerBrand/EditBrand/{id}")
	public ModelAndView EditBrand(@PathVariable Integer id) {
		ModelAndView modelAndView =  new ModelAndView("admin/ManagerBrand/EditBrand");
		Brand brandDetail =  brandMapper.selectByPrimaryKey(id);
		modelAndView.addObject("brandDetail",brandDetail);

		return modelAndView;
	}
	@PostMapping("/ManagerBrand/EditBrand")
	public ModelAndView EditBrandPost(HttpServletRequest request) {
		ModelAndView modelAndView =  new ModelAndView("admin/ManagerBrand/EditBrand");
		String Brandname =  request.getParameter("Brandname");
		String ImgBrand =  request.getParameter("img");
		String active =  request.getParameter("active");
		String BrandId =  request.getParameter("BrandId");
		System.out.println(BrandId);
		Brand BrandUpdate = new Brand(Integer.parseInt(BrandId), Brandname, Integer.parseInt(active),ImgBrand);
		
	List<Map<String, Object>> check = brandMapper.getIdBrandName(Brandname);
		
		
		if(check.size() > 1) {
			modelAndView.addObject("message","Thương hiệu đã tồn tại");

		}else {
			brandMapper.updateByPrimaryKeySelective(BrandUpdate);
			modelAndView.addObject("message","Cập nhật thương hiệu thành công");

		}		
	



		

		
		

		return modelAndView;
	}
	

	@PostMapping("/ManagerBrand/AddBrand")
	public ModelAndView ProcessaddBrand(HttpServletRequest request) {
		ModelAndView modelAndView =  new ModelAndView("admin/ManagerBrand/AddBrand");
		String Brandname =  request.getParameter("Brandname");
		String Imgproduct =  request.getParameter("img");
		String active =  request.getParameter("active");
		
		Brand brandNew =  new Brand(Brandname, Integer.parseInt(active),Imgproduct );
		
		List<Map<String, Object>> check = brandMapper.getIdBrandName(Brandname);
		
		
		if(check.size() > 0) {
			modelAndView.addObject("message","Thương hiệu đã tồn tại");

		}else {
			brandMapper.insert(brandNew);
			modelAndView.addObject("message","Thêm thương hiệu thành công");

		}
		

		return modelAndView;
	}
	//manager category

	@GetMapping("/ManagerCategory/AddCategory")
	public ModelAndView addCategory() {
		ModelAndView modelAndView =  new ModelAndView("admin/ManagerCategory/AddCategory");
		return modelAndView;
	}
	@GetMapping("/ManagerCategory/removeCategories/{id}")
	public ModelAndView removeCategories(@PathVariable Integer id) {
		ModelAndView modelAndView =  new ModelAndView("admin/ManagerCategory/ListCategory");
		categoriesMapper.deleteByPrimaryKey(id);
		
		return modelAndView;
	}
	
	@PostMapping("/ManagerCategory/AddCategory")
	public ModelAndView ProcessaddCategory(HttpServletRequest request) {
		ModelAndView modelAndView =  new ModelAndView("admin/ManagerCategory/AddCategory");
		String NameCategory =  request.getParameter("NameCategory");
		String active =  request.getParameter("active");	

		Categories categories =  new Categories(NameCategory, Integer.parseInt(active));
		List<Map<String, Object>> check = categoriesMapper.checkNameCategories(NameCategory.toString());
		if(check.size() > 0) {
			modelAndView.addObject("message","Thể loại đã tồn tại");

		}else {
			categoriesMapper.insert(categories);
			modelAndView.addObject("message","Thêm thể loại thành công");

		}
		
		return modelAndView;
	}
	
	@GetMapping("/ManagerCategory/ListCategory")
	public ModelAndView ListCategory() {
		ModelAndView modelAndView =  new ModelAndView("admin/ManagerCategory/ListCategory");
		CategoriesExample categoriesExample =  new CategoriesExample();
		List<Categories> listCategories =  categoriesMapper.selectByExample(categoriesExample);
		modelAndView.addObject("listCategories",listCategories);

		return modelAndView;
	}
	@GetMapping("/ManagerCategory/EditCategory/{id}")
	public ModelAndView EditCategory(@PathVariable Integer id) {
		ModelAndView modelAndView =  new ModelAndView("admin/ManagerCategory/EditCategory");
		
		Categories categoriesDetail = categoriesMapper.selectByPrimaryKey(id);
		modelAndView.addObject("categoriesDetail",categoriesDetail);

		return modelAndView;
	}
	@PostMapping("/ManagerCategory/EditCategory")
	public ModelAndView EditCategoryProcess(HttpServletRequest request) {
		ModelAndView modelAndView =  new ModelAndView("admin/ManagerCategory/EditCategory");
		
		String NameCategory =  request.getParameter("NameCategory");
		String active =  request.getParameter("active");	
		String idCategory =  request.getParameter("idCategory");	

		Categories categories =  new Categories(Integer.parseInt(idCategory),NameCategory, Integer.parseInt(active));

		List<Map<String, Object>> check = categoriesMapper.checkNameCategories(NameCategory.toString());
		if(check.size() > 0) {
			modelAndView.addObject("message","Thể loại đã tồn tại");

		}
		if(check.size() == 1) {
			modelAndView.addObject("message","Lưu thể lọai thành công ");

		}else {
			categoriesMapper.updateByPrimaryKeySelective(categories);
			modelAndView.addObject("message","Cập nhật thể loại thành công");

		}
		return modelAndView;
	}
	@Autowired
	CheckoutMapper checkoutMapper;
	@Autowired
	CartMapper cartMapper;
	// Manager Order
	@GetMapping("/ManagerOrder/ListWait")
	public ModelAndView ListWait() {
		ModelAndView modelAndView =  new ModelAndView("admin/ManagerOrder/ListOrderWait");
//		CategoriesExample categoriesExample =  new CategoriesExample();
//		List<Categories> listCategories =  categoriesMapper.selectByExample(categoriesExample);
//		modelAndView.addObject("listCategories",listCategories);
		
	
			
		List<Map<String, Object>> listOrder =  checkoutMapper.listOrderWait();
		modelAndView.addObject("listOrder",listOrder);

		return modelAndView;
	}
	@GetMapping("/ManagerOrder/DetailOrder/{id}")
	public ModelAndView DetailOrder(@PathVariable Integer id) {
		ModelAndView modelAndView =  new ModelAndView("admin/ManagerOrder/DetailOrder");
//		CategoriesExample categoriesExample =  new CategoriesExample();
//		List<Categories> listCategories =  categoriesMapper.selectByExample(categoriesExample);
//		modelAndView.addObject("listCategories",listCategories);
		
		List<Map<String,Object>> list = cartMapper.getDetailProduct(id);
//		System.out.print(list);
			
//		List<Map<String, Object>> listOrder =  checkoutMapper.listOrderWait();
		modelAndView.addObject("list",list);

		return modelAndView;
	}
	
	@GetMapping("/ManagerOrder/acceptProduct/{id}")
	public ModelAndView acceptProduct(@PathVariable Integer id) {
		ModelAndView modelAndView =  new ModelAndView("admin/ManagerOrder/ListOrderWait");
		
		checkoutMapper.updateSendProduct(id);

		return modelAndView;
	}
	
}
