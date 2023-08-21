package com.cc.test.jsdk.base;

import com.cc.jsdk.base.classloader.BytecodeFileClassLoader;
import org.junit.jupiter.api.Test;

/**
 * @author cc
 * Create at 2023-08-21
 */
public class ClassLoaderTest {

    @Test
    public void testLoad() {
        try {
            BytecodeFileClassLoader bytecodeFileClassLoader = new BytecodeFileClassLoader();
            bytecodeFileClassLoader.setFilePath("/Users/sen.hu/Desktop/mytest");
            bytecodeFileClassLoader.loadClass();
            Class<?> dog = bytecodeFileClassLoader.getLoadedClass("com.cc.jsdk.base.test.Dog");
            Object o = dog.newInstance();
            System.out.println(o.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
