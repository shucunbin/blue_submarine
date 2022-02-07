package io.blue.submarine.han.web;

import io.blue.submarine.han.service.ResidentSubsidyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 居民补贴请求处理类.
 *
 * @author shucunbin
 * @date 2022-02-07 13:02
 */
@RestController
@RequestMapping("/admin/subsidy/v1")
public class ResidentSubsidyInfoController {
    @Autowired
    private ResidentSubsidyInfoService residentSubsidyInfoService;

    @GetMapping("export")
    public void exportExcel() {
        residentSubsidyInfoService.exportExcel();
    }

    @GetMapping("init")
    public void initData() {
        residentSubsidyInfoService.initData();
    }
}
