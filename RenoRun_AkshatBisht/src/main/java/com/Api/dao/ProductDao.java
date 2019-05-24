package com.Api.dao;
import java.util.Collection;
import com.Api.entity.Product;

public interface ProductDao {

    Collection<Product> getAllProducts();

    Product getProductById(int id);

    void removeProductById(int id);

    void updateProduct(Product product);

    void insertProductToDb(Product product);
}
