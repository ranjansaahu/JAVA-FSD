package org.productdb.Repo;

import org.productdb.Model.Product;

import java.util.List;

public interface ProductRepo {

    public boolean addProduct(Product product);
    public boolean updateProduct(Product product);
    public boolean deleteById(int productId);
    public List<Product> findAll();
    public Product findById(int productId);
    public void closeConnection();
}
