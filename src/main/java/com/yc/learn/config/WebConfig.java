package com.yc.learn.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.yc.learn.jackson.DefaultJsonDeserializer;
import com.yc.learn.jackson.DefaultJsonSerializer;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author: yc
 * @Date: 2017-7-28 17:38
 * @EnableWebMvc == <mvc:annotation-driven />
 * @ComponentScan == < context:component-scan base-package= "org.rest" />
 * @EnableAspectJAutoProxy == <aop:aspectj-autoproxy>
 * @ImportResource == <import resource=”classpath*:/spring-mvc.xml” />
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.yc.learn")
public class WebConfig extends WebMvcConfigurerAdapter {

  public Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 这种方式会覆盖spring默认添加的几种HttpMessageConverter， 若只想额外添加一种自定义的HttpMessageConverter，使用extendMessageConverters（推荐）
   */
  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    SimpleModule module = new SimpleModule();
    module.addDeserializer(String.class, new DefaultJsonDeserializer());
    module.addSerializer(String.class, new DefaultJsonSerializer());
    ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().build();
    mapper.registerModule(module);
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(mapper);

    converters.add(converter);
  }

  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    //... TODO 额外添加转换器 ....
  }
}
