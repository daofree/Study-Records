package com.daofree;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @ClassName FileDemoFilter
 * @Description: 文件名称过滤器
 * @Author DaoTianXia
 * @Date 2020-05-23-18:36
 * @Version V1.0
 **/
public class FileDemoFilter {
    public static void main(String[] args) {
        File file = new File("g:\\");
        String[] list = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File file1 = new File(dir, name);
                boolean flag = file1.isFile();
                boolean flag2 = name.endsWith(".jpg");

                //return new File(dir, name).isFile() && name.endsWith(".jpg");
                return flag && flag2;
            }
        });

        for(String s : list){
            System.out.println(s);
        }
    }
}
