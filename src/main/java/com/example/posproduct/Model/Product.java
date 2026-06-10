package com.example.posproduct.Model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ProductDB")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "category")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer quantity;

    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
}
