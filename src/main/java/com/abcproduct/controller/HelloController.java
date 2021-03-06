package com.abcproduct.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.abcproduct.org.ranc.AbcProduct.domain.model.TestTableModel;
import com.abcproduct.org.ranc.AbcProduct.domain.repository.TestTableRepository;

@Controller
public class HelloController {

	@Autowired
	TestTableRepository testTableRepository;

    @GetMapping("/")
    public String index() {
		return "index";
    }


    @RequestMapping(path = "hello", method = RequestMethod.GET)
    public String hello(Model model,@RequestParam("id") int id) {
    	int i = id;
    	TestTableModel testTableModel = testTableRepository.selectByPrimaryKey(id);


    	model.addAttribute("testTable", testTableModel);
    	model.addAttribute("greeting", "Hello,World!");
        return "hello";
    }
}
