package com.maxzuo.easycode.day3;

import com.maxzuo.easycode.day3.pojo.Employee;

/**
 * Created by zfh on 2019/03/22
 */
public class Engineer extends Employee {

    private String position;

    public Engineer(String name, Integer age, String position) {
        super(name, age);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    @Override
    protected String getName() {
        return super.getName();
    }
}
