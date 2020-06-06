package com.diego.ecommerce.repositories;

import com.diego.ecommerce.data.entities.Addres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddresRepository extends JpaRepository<Addres, Long> {
}
