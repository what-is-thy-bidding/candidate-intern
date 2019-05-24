package com.Api.service;

import com.Api.dao.ProductDao;
import com.Api.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductService {

    @Autowired
    @Qualifier("mysql")
    private ProductDao productDao;

    public Collection<Product> getAllProducts(){
        return this.productDao.getAllProducts();
    }

    public Product getProductById(int id){return this.productDao.getProductById(id);}


    public void removeProductById(int id) {
        this.productDao.removeProductById(id);
    }

    public void updateProduct(Product product){
        this.productDao.updateProduct(product);
    }

    public void insertProduct(Product product) {
        this.productDao.insertProductToDb(product);
    }
}