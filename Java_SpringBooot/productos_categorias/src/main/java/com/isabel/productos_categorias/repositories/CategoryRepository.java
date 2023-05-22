package com.isabel.productos_categorias.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isabel.productos_categorias.models.Category;
import com.isabel.productos_categorias.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

	List<Category> findAll();
//	busca todas las categorias que no tenga ese producto
	List<Category> findByProductsNotContains(Product producto);
	
    @Query(value = "SELECT c.name AS name,COUNT(pc.product_id) AS productCount FROM categories c LEFT JOIN productoscategorias pc ON c.id = pc.category_id GROUP BY c.id", nativeQuery = true)
    List<Object[]> getCategoryTable();
}
