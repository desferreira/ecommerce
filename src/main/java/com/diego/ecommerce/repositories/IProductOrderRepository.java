package com.diego.ecommerce.repositories;

import com.diego.ecommerce.data.entities.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductOrderRepository extends JpaRepository<ProductOrder, Long> {

    List<ProductOrder> findByClient_Id(Long id);
}
