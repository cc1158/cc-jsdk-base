package com.cc.jsdk.base.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 字节码类加载器
 *
 * @author cc
 * Create at 2023-08-19
 */
public class BytecodeFileClassLoader extends ClassLoader {

    private final Map<String, Class<?>> CLASS_MAP = new ConcurrentHashMap<>(10);

    private String filePath;

    private String classSuffix = ".class";

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void loadClass() {
        CLASS_MAP.clear();
        File rootDir = new File(filePath);
        if (Boolean.FALSE.equals(rootDir.isDirectory())) {
            throw new IllegalArgumentException(filePath + " Not A Directory");
        }
        List<File> classFiles = genAllClassFile(rootDir);
        for (File file : classFiles) {
            byte[] classBytes = readClass(file);
            if (classBytes.length == 0) {
                continue;
            }
            Class<?> clazz = defineClass(null, classBytes, 0, classBytes.length);
            CLASS_MAP.put(clazz.getName(), clazz);
        }
    }

    private List<File> genAllClassFile(File rootDirFile) {
        List<File> dirFiles = new ArrayList<>(10);
        dirFiles.add(rootDirFile);
        File dirFile = null;
        List<File> classFiles = new ArrayList<>(10);
        do {
            dirFile = dirFiles.remove(0);
            if (Objects.isNull(dirFile)) {
                break;
            }
            File[] subFiles = dirFile.listFiles();
            if (Objects.isNull(subFiles)) {
                break;
            }
            for (File file : subFiles) {
                if (file.isDirectory()) {
                    dirFiles.add(file);
                    continue;
                }
                if (!file.getName().endsWith(classSuffix)) {
                    continue;
                }
                classFiles.add(file);
            }
        } while (dirFiles.size() > 0);
        return classFiles;
    }

    private byte[] readClass(File classFile) {
        ByteArrayOutputStream write = null;
        FileInputStream read = null;
        try {
            read = new FileInputStream(classFile);
            write = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int readNum = 0;
            while ((readNum = read.read(buffer)) != -1) {
                write.write(buffer, 0, readNum);
            }
            return write.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(read)) {
                try {
                    read.close();
                } catch (IOException e) {
                }
            }
            if (Objects.nonNull(write)) {
                try {
                    write.flush();
                    write.close();
                } catch (IOException e) {
                }
            }
        }
        return new byte[0];
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> ret = CLASS_MAP.get(name);
        if (ret == null) {
            ret = super.findClass(name);
        }
        return ret;
    }

    public Class<?> getLoadedClass(String name) throws ClassNotFoundException {
        return findClass(name);
    }
}
