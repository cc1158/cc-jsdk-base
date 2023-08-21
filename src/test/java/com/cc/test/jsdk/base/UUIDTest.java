package com.cc.test.jsdk.base;

import com.cc.jsdk.base.UUID;
import org.junit.jupiter.api.Test;

/**
 * @author cc
 * Create at 2023-08-14
 */
public class UUIDTest {

    @Test
    public void testGen() {
        int i = 99999;
        while (i > 0) {
            String s = UUID.uuId();
            System.out.println(s);
            i--;
        }
    }
}
