package com.adv.demo.controller;

import com.adv.demo.model.ResponseEntity;
import com.adv.demo.service.AlgebraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.adv.demo.model.Params;

import javax.validation.Valid;

@RestController
public class Controller {

    @Autowired
    private AlgebraService algebra;

    @PostMapping(value = "/quad")
    public @ResponseBody ResponseEntity calculateRoots(@Valid @RequestBody(required = true)Params params){
        ResponseEntity responseEntity =  algebra.findRoots(params);
        return responseEntity;
    }

}
