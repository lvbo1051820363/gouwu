package cn.itsource.gouwu.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "COMMON-PRIVODER",fallbackFactory =RedisClientFactory.class )
@RequestMapping("/common")
public interface RedisClient {

    @RequestMapping(value = "/redis", method = RequestMethod.POST)
    void set(@RequestParam("key") String key, @RequestParam("value") String value);

    @RequestMapping(value = "/redis/{key}", method = RequestMethod.GET)
    String get(@PathVariable("key") String key);
}
