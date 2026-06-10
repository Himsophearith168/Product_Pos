package com.example.posproduct.Repository;

import com.example.posproduct.Model.Oder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Oder, Long> {
}
