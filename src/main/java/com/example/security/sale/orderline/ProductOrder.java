package com.example.security.sale.orderline;

import com.example.security.product.Product;
import com.example.security.sale.SaleOperation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_productOrder")
public class ProductOrder {//order line

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "sale_operation_id")
    private SaleOperation saleOperation;

    int quantity;
    double productPrice;    //because if we change the price of the product in the future
    double totalPrice;  //I don't want to calculate it every time
}
