package com.isabel.productos_categorias.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isabel.productos_categorias.models.Category;
import com.isabel.productos_categorias.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();
	
	List<Product> findByCategoriesNotContains(Category category);
	
	//necesito mostrar nombre,descripcion,precio y la cantidad de categorias que tiene cada producto

    @Query(value = "SELECT p.name AS name,p.description AS description, p.price AS price, COUNT(pc.category_id) AS categoryCount FROM Products p LEFT JOIN productoscategorias pc ON p.id = pc.product_id GROUP BY p.id", nativeQuery = true)
    List<Object[]> getProductTable();
}
