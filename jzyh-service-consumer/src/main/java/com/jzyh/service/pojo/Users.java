package com.jzyh.service.pojo;


public class Users {
  private Integer uid;
  private String name;
  private String password;
  private Integer age;


  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public void text(){
    int i = 0;
    i++;
    System.out.println(i);
  }

}
