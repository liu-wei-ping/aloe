package com.aloe.controller.wechat;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("wechat")
public class ArticleController {
    /**
     * @param context
     * @return
     */
    @RequestMapping(value = "/article/create", method = RequestMethod.POST)
    public Map<String, String> createArticleInfo(@RequestHeader("auth-token") String token, @RequestBody String context) {
        Map<String, String> result = new HashMap<>();
        System.out.println("token======>" + token);
        System.out.println("context====>" + context);
        result.put("result", context);
        return result;
    }
}
