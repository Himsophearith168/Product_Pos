package com.example.posproduct.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "payments")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Oder order;

    @Column(nullable = false)
    private Double amount;
    private String remark;


}
