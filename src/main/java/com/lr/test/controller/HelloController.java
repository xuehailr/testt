package com.lr.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Administrator on 2017/11/28.
 */
@Controller
@RequestMapping("/back")
public class HelloController {

    @Autowired
    private CacheManager cacheManager;

    @RequestMapping
    public String userMng(String token) {
        Cache cache = cacheManager.getCache("tokenCache");
        System.out.println(cache.get("token")!=null?cache.get("token").get():null);
        cache.put("token",token);
        System.out.println(cache.get("token").get());
        return "back/userMng";
    }
    @RequestMapping("/roleMng")
    public String roleMng(String token,Map<String,Object> map ) {
        Cache cache = cacheManager.getCache("tokenCache");
        System.out.println(cache.get("token")!=null?cache.get("token").get():null);
        cache.put("token",token);
        System.out.println(cache.get("token").get());
        map.put("name","lirong");
        return "back/roleMng";
    }
}
