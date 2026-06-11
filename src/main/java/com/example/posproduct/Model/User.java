package com.example.posproduct.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false , length = 20 , unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Oder> orders;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Payment> payments;
}
