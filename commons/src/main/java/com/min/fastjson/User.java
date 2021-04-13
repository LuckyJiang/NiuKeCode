package com.min.fastjson;

/**
 * @author jxm
 * @version 1.0
 * @date 2021/4/13 11:26
 */
public class User {
    private String name;
    private Integer age;
    private String location;
    public User() {
    }
    public User(String name) {
        this.name = name;
    }
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public User(String name, Integer age, String location) {
        this.name = name;
        this.age = age;
        this.location = location;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", location='" + location + '\'' +
                '}';
    }
}