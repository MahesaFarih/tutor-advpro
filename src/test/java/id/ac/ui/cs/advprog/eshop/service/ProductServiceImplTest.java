package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
    }

    @Test
    void testCreateProduct() {
        when(productRepository.create(product)).thenReturn(product);

        Product createdProduct = productService.create(product);
        assertEquals(product, createdProduct);
        verify(productRepository).create(product);
    }

    @Test
    void testEditProduct() {
        Product updatedProduct = new Product();
        updatedProduct.setProductId("a0f9de46-90b1-437d-a0bf-a093edde8087");
        updatedProduct.setProductName("Sampo Cap Jarwo");
        updatedProduct.setProductQuantity(500);

        when(productRepository.editProduct("Sampo Cap Bambang", updatedProduct)).thenReturn(updatedProduct);

        Product result = productService.edit("Sampo Cap Bambang", updatedProduct);
        assertEquals(updatedProduct, result);
        verify(productRepository).editProduct("Sampo Cap Bambang", updatedProduct);
    }

    @Test
    void testDeleteProduct() {
        when(productRepository.deleteProduct("Sampo Cap Bambang")).thenReturn(product);

        Product deletedProduct = productService.delete("Sampo Cap Bambang");
        assertEquals(product, deletedProduct);
        verify(productRepository).deleteProduct("Sampo Cap Bambang");
    }

    @Test
    void testFindAllProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(product);

        Iterator<Product> iterator = productList.iterator();
        when(productRepository.findAll()).thenReturn(iterator);

        List<Product> result = productService.findAll();
        assertEquals(productList, result);
        verify(productRepository).findAll();
    }

    @Test
    void testFindProductByName() {
        when(productRepository.findProduct("Sampo Cap Bambang")).thenReturn(product);

        Product result = productService.find("Sampo Cap Bambang");
        assertEquals(product, result);
        verify(productRepository).findProduct("Sampo Cap Bambang");
    }
}