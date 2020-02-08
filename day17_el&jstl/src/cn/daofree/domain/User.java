package cn.daofree.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName User
 * @Description: TODO
 * @Author DaoTianXia
 * @Date 2020-02-08-12:12
 * @Version V1.0
 **/
public class User {

    private String name;
    private int age;
    private Date birthday;

    /**
     *
     * @Description:
     *         逻辑视图
     * @param: []
     * @return: java.lang.String
     * @Author: daofree
     * @Date: 12:31 2020/2/8
     *
     */
    public String getBirStr(){

        if(birthday!=null){
            // 1.格式化日期对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // 返回字符串
            return sdf.format(birthday);
        }else {
            return "";
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
