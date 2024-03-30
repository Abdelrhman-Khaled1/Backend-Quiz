package com.example.security.sale.orderline;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepo extends JpaRepository<ProductOrder,Long> {
}
