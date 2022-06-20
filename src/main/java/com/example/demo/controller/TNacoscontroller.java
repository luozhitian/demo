package com.example.demo.controller;


import com.example.demo.vo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dnacos")
public class TNacoscontroller {

    @Autowired
    private RedisTemplate redisTemplate;
    @GetMapping("sayHello")
    @ResponseBody
    public String hello(@RequestParam String str){
        System.out.println(str+"hhh");
        return str+"hello";
    }

    @Value("${nss}")
    private String v1;

    @Value("${kkl}")
    private String v2;
    @GetMapping("query")
    @ResponseBody
    public String query(@RequestParam String name){


        return v1+"--"+v2;
    }

    @PostMapping("insert")
    @ResponseBody
    public int insert(@RequestBody People peo){
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set(peo.getName(),peo.getWork());
        return 1;
    }

    @GetMapping("delete")
    @ResponseBody
    public int delete(@RequestParam String name){
        ValueOperations ops = redisTemplate.opsForValue();
        ops.decrement(name);
        return 1;
    }

    @Value("${spring.application.name}")
    private String cn;

    @Value("${spring.cloud.nacos.config.server-addr}")
    private String an;
    @GetMapping("t2")
    @ResponseBody
    public String t2(@RequestParam String name){
        System.out.println(cn);
        System.out.println(an);

        return cn+"-"+an;
    }
}
