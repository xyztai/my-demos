package com.param.check.controller;

import com.param.check.entity.ParamIn;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParamWeb {

    @GetMapping("/param/single/{id}")
    public String paramSingle (@PathVariable Integer id){
        return "Resp:"+id ;
    }

    @GetMapping("/param/multi")
    public String paramMulti (@RequestParam("key") String key,
                              @RequestParam("var") String var){
        return "Resp:"+key+var ;
    }

    @PostMapping("/param/wrap")
    public ParamIn paramWrap (@RequestBody ParamIn paramIn){
        return paramIn ;
    }
}
