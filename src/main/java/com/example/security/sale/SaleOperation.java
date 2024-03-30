package com.example.security.sale;

import com.example.security.client.Client;
import com.example.security.sale.orderline.ProductOrder;
import com.example.security.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_saleOperation")
@EntityListeners(AuditingEntityListener.class)
public class SaleOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private User seller;

    @OneToMany(mappedBy = "saleOperation")
    private Set<ProductOrder> productOrders;

    @ManyToOne
    @JsonIgnore
    private Client client;

}
