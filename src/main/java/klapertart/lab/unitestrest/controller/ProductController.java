package klapertart.lab.unitestrest.controller;

import klapertart.lab.unitestrest.data.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * @author kurakuraninja
 * @since 10/02/23
 */

@RestController
@RequestMapping("/api")
public class ProductController {

    @GetMapping("/welcome")
    public String welcome(){
        return "API Central 0.0";
    }

    @GetMapping("/messages")
    public Map<String,String> messages(){
        return Collections.singletonMap("message","Greeting from API");
    }

    @GetMapping("/product")
    public Product product(){
        Product product = Product.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .name("Snack")
                .price(5500L)
                .build();

        return product;
    }
}
