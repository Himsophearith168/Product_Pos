package com.example.posproduct.Model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "OrderDetails")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Oder order;

    private Integer quantity;
    private String description;
}
