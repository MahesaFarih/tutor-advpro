package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductService {
    public Product create(Product product);
    public Product edit(String name,Product product);
    public Product delete(String name);
    public Product find(String name);
    public List<Product> findAll();
}
