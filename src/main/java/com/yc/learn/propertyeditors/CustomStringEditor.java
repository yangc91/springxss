package com.yc.learn.propertyeditors;

import java.beans.PropertyEditorSupport;
import org.springframework.web.util.HtmlUtils;

/**
 * String类型转化器
 *
 * @author: yc
 * @date: 2017-12-25.
 */
public class CustomStringEditor extends PropertyEditorSupport {

  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    if (text == null || text.equals("")) {
      text = "";
    }
    // xss过滤，表单提交时封装参数，String类型会经过此处
    text = HtmlUtils.htmlEscape(text, "utf-8");
    setValue(text);
  }

  @Override
  public String getAsText() {
    return getValue().toString();
  }
}
