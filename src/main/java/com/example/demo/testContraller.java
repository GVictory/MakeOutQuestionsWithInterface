package com.example.demo;

import org.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by GMUK on 2018/10/24 0024.
 */
@RestController
public class testContraller {
    @GetMapping("/hello")
    public HashMap<String, Integer> getArithmetic(@RequestParam Integer count) throws JSONException {
        return new Arithmetic().getArithmetic(count);
    }
}
