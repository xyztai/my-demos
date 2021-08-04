package com.param.check.controller;

import com.param.check.entity.KeyValue;
import com.param.check.entity.Resp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RespWeb {
    /**
     {
        "code": 200,
        "msg": "OK",
        "data": {
            "key": "hello",
            "value": "world"
        }
     }
     */
    @PostMapping("/resp/wrap")
    public Resp<KeyValue> respWrap (@RequestBody KeyValue keyValue){
        return Resp.ok(keyValue) ;
    }
}
