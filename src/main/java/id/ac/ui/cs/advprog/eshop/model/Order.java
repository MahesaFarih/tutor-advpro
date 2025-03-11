package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;

import lombok.Getter;
import lombok.Builder;

import java.util.List;

@Builder
@Getter
public class Order {
    private String id;
    private List<Product> products;
    private Long orderTime;
    private String author;
    private String status;

    public Order(String id, List<Product> products, Long orderTime, String author) {
        this.id = id;
        this.orderTime = orderTime;
        this.author = author;
        this.status = OrderStatus.WAITING_PAYMENT.getValue();

        if (products.isEmpty()) {
            throw new IllegalArgumentException("Products list cannot be empty");
        } else {
            this.products = products;
        }
    }

    public Order(String id, List<Product> products, Long orderTime, String author, String status) {
        this(id, products, orderTime, author);
        this.setStatus(status);
    }

    public void setStatus(String status) {
        if (OrderStatus.contains(status)) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid status");
        }
    }
}