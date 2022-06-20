package com.example.demo.controller;

import com.example.demo.mapper.PeopleMapper;
import com.example.demo.vo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/demo")
public class Testcontroller {

    @Autowired
    PeopleMapper peopleMapper;
    @GetMapping("sayHello")
    @ResponseBody
    public String hello(@RequestParam String str){
        System.out.println(str+"hhh");
        return str+"hello";
    }

    @GetMapping("query")
    @ResponseBody
    public People query(@RequestParam String name){
        System.out.println(name+"hhh");
        People p= peopleMapper.queryByName(name);
        return p;
    }

    @PostMapping("insert")
    @ResponseBody
    public int insert(@RequestBody People peo){
        System.out.println("insert");
        int count = peopleMapper.insert(peo);
        return count;
    }

    @GetMapping("delete")
    @ResponseBody
    public int delete(@RequestParam String name){
        System.out.println(name+"delete");
        peopleMapper.deleteByName(name);
        return 1;
    }
}
