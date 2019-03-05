package cn.itsource.gouwu.controller;

import cn.itsource.constants.GlobelConstants;
import cn.itsource.gouwu.client.PageStaticClient;
import cn.itsource.gouwu.util.VelocityUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/common")
public class PageController implements PageStaticClient{

    @RequestMapping(value = "/page",method = RequestMethod.POST)
    public void getpageString(@RequestBody Map<String, Object> map) {
        Object model = map.get(GlobelConstants.PAGE_MODE);
        String templateFilePathAndName = (String) map.get(GlobelConstants.PAGE_TEMPLATE);
        String targetFilePathAndName = (String) map.get(GlobelConstants.PAGE_TEMPLATE_HTML);

        VelocityUtils.staticByTemplate(model, templateFilePathAndName,targetFilePathAndName );
    }
}
