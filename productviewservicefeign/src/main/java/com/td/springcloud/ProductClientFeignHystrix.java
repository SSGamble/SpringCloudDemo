package com.td.springcloud;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现了 ProductClientFeign 接口
 */
@Component
public class ProductClientFeignHystrix implements ProductClientFeign{
    /**
     * 这个方法就会固定返回包含一条信息的集合
     */
    public List<Product> listProdcuts(){
        List<Product> result = new ArrayList<>();
        result.add(new Product(0,"产品数据微服务不可用",0));
        return result;
    }

}
