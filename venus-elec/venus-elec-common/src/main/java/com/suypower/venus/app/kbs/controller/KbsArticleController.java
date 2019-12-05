package com.suypower.venus.app.kbs.controller;

import com.suypower.venus.app.kbs.entity.KbsArticleCategory;
import com.suypower.venus.app.kbs.service.IKbsArticleService;
import com.suypower.venus.platform.web.controller.BaseController;
import com.suypower.venus.platform.web.response.VenusResponse;
import com.suypower.venus.platform.web.response.VenusResponseHttpCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/app/kbs")
public class KbsArticleController extends BaseController {
    @Autowired
    private IKbsArticleService kbsArticleService;


    @RequestMapping( value = ("/queryKbsArticleCategory") )
    @ResponseBody
    public VenusResponse<List<KbsArticleCategory>> queryKbsArticleCategory() {
        List<KbsArticleCategory> result = kbsArticleService.queryKbsArticleCategory();
        return new VenusResponse(VenusResponseHttpCode.OK, result);
    }
}
