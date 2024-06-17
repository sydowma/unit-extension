package com.sydowma.unitextension;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class FooController {

    @GetMapping(path = "/foo")
    public String getFoo() {
        return "foo";
    }

}
