package com.yc.learn.controller;

import com.yc.learn.bean.User;
import com.yc.learn.propertyeditors.CustomStringEditor;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 父类控制器
 * @author: yc
 * @Date: 2017-9-15 10:47
 */
@RestController
public class BaseController {

  public Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 注册自定义的String类型的PropertyEditorSupport，处理application/x-www-form-urlencoded请求
   * @param binder
   */
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(String.class, new CustomStringEditor());
  }

  @RequestMapping("/form")
  public Object testForm(User user) {
    user.setName("<script>alert(123)</script>");
    return user;
  }

  @RequestMapping("/json")
  public Object testJson(@RequestBody User user) {
    user.setName("<script>alert(123)</script>");
    return user;
  }
}
