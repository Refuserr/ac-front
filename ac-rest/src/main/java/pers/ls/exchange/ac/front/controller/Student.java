package pers.ls.exchange.ac.front.controller;

import pers.ls.exchange.ac.front.util.Excel;

import java.util.Date;

public class Student {

    @Excel(sort = 1)
    private String name;

    @Excel(sort = 2)
    private String address;

    @Excel(sort = 3)
    private Date birth;

    @Excel(sort = 4)
    private int age;

    @Excel(sort = 5)
    private short ss;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public short getSs() {
        return ss;
    }

    public void setSs(short ss) {
        this.ss = ss;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birth=" + birth +
                ", age=" + age +
                ", ss=" + ss +
                '}';
    }
}
