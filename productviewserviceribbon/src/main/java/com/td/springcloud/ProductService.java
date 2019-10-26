package com.td.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductClientRibbon productClientRibbon;

    /**
     * 数据从 ProductClientRibbon 中获取
     */
    public List<Product> listProducts(){
        return productClientRibbon.listProdcuts();
    }
}