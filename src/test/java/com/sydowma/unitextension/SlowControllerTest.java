package com.sydowma.unitextension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(GlobalTimeOutExtension.class)
public class SlowControllerTest {

    @Test
    void testGetSlow() {
        SlowApiController slowApiController = new SlowApiController();
        String result = slowApiController.getSlow();
        assert(result.equals("slow"));
    }

    @Test
    void testGetFast() {
        SlowApiController slowApiController = new SlowApiController();
        String result = slowApiController.getFast();
        assert(result.equals("fast"));
    }

    @Test
    void testSlow2() {
        SlowApiController slowApiController = new SlowApiController();
        String result = slowApiController.slow2();
        assert(result.equals("slow"));
    }
}
