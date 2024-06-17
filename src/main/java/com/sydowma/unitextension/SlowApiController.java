package com.sydowma.unitextension;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Target;

@RequestMapping(value = "/api")
@RestController
public class SlowApiController {

    @GetMapping(path = "/slow")
    public String getSlow() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "slow";
    }

    @GetMapping(path = "/fast")
    public String getFast() {
        return "fast";
    }

    @GetMapping
    public String slow2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "slow";
    }
}
