package com.cheetah.client.services;

import com.cheetah.client.beans.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    List<Product> getAll();

    List<Product> getProductsByProducerName(String producerName);

    List<Product> getProductsByProducerName(String producerName, Pageable pageable);

}
