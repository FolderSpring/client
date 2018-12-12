package com.cheetah.client.repositories;

import com.cheetah.client.beans.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

    List<Product> findByProducer(String producer);

    List<Product> findByProducer(String producer, Pageable pageable);

}
