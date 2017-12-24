package com.yc.learn.bean;

import java.io.Serializable;

/**
 * @author: yc
 * @date: 2017-12-25.
 */
public class User implements Serializable {

  private static final long serialVersionUID = 842766678131230187L;

  private String name;

  private String sex;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }
}
