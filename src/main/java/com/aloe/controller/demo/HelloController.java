/**
 *
 */
package com.aloe.controller.demo;

import com.aloe.service.demo.IDemoService;
import com.aloe.tasks.AsyncDemoTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisCluster;

import java.util.concurrent.Future;

@RestController
@RequestMapping("/hello")
public class HelloController {
    public String changeInventoryQty() {
        return null;
    }

    @Autowired
    private IDemoService demo;
    @Autowired
    private AsyncDemoTask asyncDemoTask;


    @PostMapping("/getShopInfoByCompIdAndShopInfo")
    public String getShopInfoByCompIdAndShopInfo() {
        // final List<ShopResultVo> list = new ArrayList<>();
        // final ShopResultVo sv1 = new ShopResultVo();
        // sv1.setKeyId(1);
        // sv1.setSalePrice(new BigDecimal(300.00));
        // final ShopResultVo sv2 = new ShopResultVo();
        // sv2.setKeyId(1);
        // sv2.setSalePrice(new BigDecimal(300.00));
        // list.add(sv1);
        // list.add(sv2);
        // final Map<String, Object> map = new HashMap<>();
        // map.put("flag", 1);
        // map.put("message", "");
        // map.put("total", list.size());
        // map.put("rows", list);
        // final String result = JSONParser.toJSONString(map);
        // return result;
        return null;
    }


    @RequestMapping("/redis")
    public String findRedis() {
        return demo.findRedis();
    }

    @RequestMapping("/async")
    public String asyncTask() throws Exception {
        long start = System.currentTimeMillis();
        Future<Boolean> booleanFuture1 = asyncDemoTask.async1();
        Future<Boolean> booleanFuture2 = asyncDemoTask.async2();
        Future<Boolean> booleanFuture3 = asyncDemoTask.async3();
        while (true) {
            if (booleanFuture1.isDone() && booleanFuture1.isDone() && booleanFuture2.isDone()) {
                break;
            } else {
//                System.out.println("任务运行中。。。");
            }
        }
        long time = (System.currentTimeMillis() - start) / 1000;
        System.out.println("异步任务耗时：" + time);
        return "异步任务耗时：" + time;
    }

    @RequestMapping("/say")
    public String say(final String user) {
        return "hello " + user;
    }
}
