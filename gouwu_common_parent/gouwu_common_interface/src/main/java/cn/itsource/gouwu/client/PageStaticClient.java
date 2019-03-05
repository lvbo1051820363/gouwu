package cn.itsource.gouwu.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(value = "COMMON-PRIVODER",fallbackFactory = PageStaticFactory.class)
@RequestMapping("/common")
public interface PageStaticClient {

    @RequestMapping(value = "/page",method = RequestMethod.POST)
    void getpageString(@RequestBody Map<String,Object> map);
}
