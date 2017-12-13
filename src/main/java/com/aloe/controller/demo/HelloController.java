/**
 *
 */
package com.aloe.controller.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
	public String changeInventoryQty() {
		return null;
	}

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

	@RequestMapping("/say")
	public String say(final String user) {
		return "hello " + user;
	}
}
