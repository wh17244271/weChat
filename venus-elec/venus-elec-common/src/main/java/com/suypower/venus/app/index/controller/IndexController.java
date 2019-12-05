package com.suypower.venus.app.index.controller;

import com.suypower.venus.app.index.entity.IndexLabel;
import com.suypower.venus.app.index.service.impl.IndexServiceImpl;
import com.suypower.venus.platform.web.controller.BaseController;
import com.suypower.venus.platform.web.response.VenusResponse;
import com.suypower.venus.platform.web.response.VenusResponseHttpCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/app/index")
public class IndexController extends BaseController {
    @Autowired
    private IndexServiceImpl indexService;


    @RequestMapping( value = ("/queryIndex") )
    @ResponseBody
    public VenusResponse<List<IndexLabel>> queryIndex() {
        List<IndexLabel> indexLabels = indexService.queryIndex();
        return new VenusResponse(VenusResponseHttpCode.OK, indexLabels);
    }
}
