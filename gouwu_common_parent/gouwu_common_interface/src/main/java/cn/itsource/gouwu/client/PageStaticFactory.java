package cn.itsource.gouwu.client;

import feign.hystrix.FallbackFactory;

import java.util.Map;

public class PageStaticFactory implements FallbackFactory<PageStaticClient>{

    public PageStaticClient create(Throwable throwable) {
        return new PageStaticClient() {
            public void getpageString(Map<String, Object> map) {

            }
        };
    }
}
