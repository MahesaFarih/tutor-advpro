package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Product findProduct(String name){
        for(Product product : productData){
            if (product.getProductName().equals(name)){
                return product;
            }
        }
        return null;
    }

    public Product editProduct(String name, Product newProduct){
        Product product = findProduct(name);
        product.setProductName(newProduct.getProductName());
        product.setProductId(newProduct.getProductId());
        product.setProductQuantity(newProduct.getProductQuantity());
        return null;
    }

    public Iterator <Product> findAll() {
        return productData.iterator();
    }
}
