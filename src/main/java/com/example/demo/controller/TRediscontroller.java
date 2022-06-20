package com.example.demo.controller;

import com.example.demo.mapper.PeopleMapper;
import com.example.demo.vo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dredis")
public class TRediscontroller {

    @Autowired
    private RedisTemplate redisTemplate;
    @GetMapping("sayHello")
    @ResponseBody
    public String hello(@RequestParam String str){
        System.out.println(str+"hhh");
        return str+"hello";
    }

    @GetMapping("query")
    @ResponseBody
    public String query(@RequestParam String name){
        ValueOperations ops = redisTemplate.opsForValue();

        return (String)ops.get(name);
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
}
