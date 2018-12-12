package com.cheetah.client.services;

import com.cheetah.client.beans.Product;
import com.cheetah.client.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getAll() {
        return (List<Product>) repository.findAll();
    }

    @Override
    public List<Product> getProductsByProducerName(String producerName) {
        return repository.findByProducer(producerName);
    }

    @Override
    public List<Product> getProductsByProducerName(String producerName, Pageable pageable) {
        return repository.findByProducer(producerName, pageable);
    }

}
