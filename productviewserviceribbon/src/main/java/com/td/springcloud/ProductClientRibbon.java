package com.td.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;

/**
 * Ribbon 客户端
 */
@Component
public class ProductClientRibbon {

    @Autowired
    RestTemplate restTemplate;

    public List<Product> listProdcuts() {
        // 通过 restTemplate 访问 http://PRODUCT-DATA-SERVICE/products
        // 而 product-data-service 既不是域名也不是 ip 地址，而是 数据服务在 eureka 注册中心的名称。
        return restTemplate.getForObject("http://PRODUCT-DATA-SERVICE/products",List.class);
    }
}
