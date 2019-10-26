package com.td.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/**
 * 控制器，把数据取出来放在 product.html 中
 */
@Controller
@RefreshScope
public class ProductController {

    @Autowired
    ProductService productService;

    // 增加这个属性，就可以从 config-server 去获取 version 信息了。
    @Value("${version}")
    String version;

    @RequestMapping("/products")
    public Object products(Model m) {
        List<Product> ps = productService.listProducts();
        m.addAttribute("ps", ps);
        m.addAttribute("version", version); // 将 version 信息放在 model 里
        return "products";
    }
}