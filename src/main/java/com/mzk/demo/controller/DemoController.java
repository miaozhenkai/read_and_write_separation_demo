package com.mzk.demo.controller;

import com.mzk.demo.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: read_and_write_separation_demo
 * @description: read_and_write_separation_demo
 * @author: miaozhenkai
 * @create: 2019-10-16 09:20
 */
@RestController
@CrossOrigin(origins = "*")
@Api(description = "数据申请接口")
@RequestMapping("test")
public class DemoController {

    @Autowired
    DemoService demoService;

    @ApiOperation(value = "测试读")
    @GetMapping("/testRead")
    public String testRead() {
        return demoService.testRead().toString();
    }

    @ApiOperation(value = "测试写")
    @GetMapping("/testWrite")
    public String testWrite() {
        return demoService.testWrite();
    }

    @ApiOperation(value = "测试事务")
    @GetMapping("/testTransaction")
    public String testTransaction() {
        return demoService.testTransaction();
    }

    @ApiOperation(value = "测试更新")
    @GetMapping("/testUpdate")
    public String testUpdate() {
        return demoService.testUpdate();
    }

    @ApiOperation(value = "测试删除")
    @GetMapping("/testDelete")
    public String testDelete(int i) {
        return demoService.testDelete(i);
    }

}
