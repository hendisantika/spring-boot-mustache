package com.hendisantika.springbootmustache.controller;

import com.hendisantika.springbootmustache.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mustache
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/01/20
 * Time: 06.22
 */
@Controller
public class MustacheController {
    @GetMapping("/products")
    public String getProducts(Map<String, Object> model) {
        List<Product> productList = IntStream.range(0, 7).mapToObj(i -> getProduct(i)).collect(Collectors.toList());
        model.put("productList", productList);
        return "product";
    }

    private Product getProduct(int i) {
        return new Product(String.valueOf(i), "Product" + i, "Sample Description " + i, 100 + i);
    }
}
