package com.isabel.productos_categorias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isabel.productos_categorias.models.Category;
import com.isabel.productos_categorias.models.Product;
import com.isabel.productos_categorias.models.ProductCategory;
import com.isabel.productos_categorias.repositories.CategoryRepository;
import com.isabel.productos_categorias.repositories.ProductCategoryRepository;
import com.isabel.productos_categorias.repositories.ProductRepository;

@Service
public class MainServices {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	    // SERVICIOS PARA Product
		public Product crearProduct(Product Product) {
			return productRepository.save(Product);
		}
		public List<Product> todosProducts(){
			return productRepository.findAll();
			}
		public Product getProduct(Long idProduct) {
			return productRepository.findById(idProduct).orElse(null);
		}
		
		public List<Product> CategoriasSinProducto(Category category){
			return productRepository.findByCategoriesNotContains(category);
		}
		
		 public List<Object[]> getProductTable() {
		        return productRepository.getProductTable();
		    }
		
		//SERVICIOS PARA CategoryS
		public Category crearCategory(Category Category) {
			return categoryRepository.save(Category);
		}
		public List<Category> todosCategorys(){
			return categoryRepository.findAll();
			}
		public List<Category> ProductSinCategory(Product Product){
			return categoryRepository.findByProductsNotContains(Product);
		}
		
		public Category getCategory(Long idCategory) {
			return categoryRepository.findById(idCategory).orElse(null);
		}
		 public List<Object[]> getCategoryTable() {
		        return categoryRepository.getCategoryTable();
		}
		
		
		//SERVICIOS TABLA INTERMEDIA
		public ProductCategory crearVinculo(ProductCategory ProductsCategorys) {
			return productCategoryRepository.save(ProductsCategorys);
		}
}
