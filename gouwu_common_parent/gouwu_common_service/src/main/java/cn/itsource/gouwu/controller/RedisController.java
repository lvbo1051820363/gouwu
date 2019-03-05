package cn.itsource.gouwu.controller;

import cn.itsource.gouwu.client.RedisClient;
import cn.itsource.gouwu.util.RedisUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/common")
public class RedisController implements RedisClient{

    @RequestMapping(value = "/redis",method = RequestMethod.POST)
    @Override
    public void set(@RequestParam("key") String key, @RequestParam("value") String value) {
        RedisUtil.set(key, value);
    }

    @RequestMapping(value = "/redis/{key}",method = RequestMethod.GET)
    @Override
    public String get(@PathVariable("key") String key) {
        return RedisUtil.get(key);
    }
}
