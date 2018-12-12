package com.cheetah.client.controllers;

import com.cheetah.client.services.IProductService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {

    private Logger log = LoggerFactory.getLogger(ProductsController.class);
    private Gson gson = new Gson();

    @Autowired
    IProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public String showInfo() {
        String result = gson.toJson(productService.getAll());
        log.debug(result);
        return result;
    }

    @RequestMapping(value = "/{producerName}", method = RequestMethod.GET, produces = "application/json")
    public String getProductsByProducerName(@PathVariable String producerName) {
        String result = gson.toJson(productService.getProductsByProducerName(producerName));
        log.debug(result);
        return result;
    }

    @RequestMapping(value = "/{producerName}/{page}/{limit}", method = RequestMethod.GET, produces = "application/json")
    public String getProductsByProducerName(@PathVariable String producerName, @PathVariable int page, @PathVariable int limit) {
        String result = gson.toJson(productService.getProductsByProducerName(producerName, PageRequest.of(page - 1, limit)));
        log.debug(result);
        return result;
    }

}
