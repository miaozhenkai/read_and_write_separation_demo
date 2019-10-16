package com.mzk.demo;

import com.mzk.demo.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReadAndWriteSeparationDemoApplicationTests {
    @Autowired
    DemoService demoService;

    @Test
    public void contextLoads() {

        System.out.println(1);
        demoService.getAll();
    }

}
