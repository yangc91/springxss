package com.yc.learn.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.yc.learn.jackson.DefaultJsonDeserializer;
import com.yc.learn.jackson.DefaultJsonSerializer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * ObjectMapper工厂类，添加自定义序列化转化器
 *
 * @author: yc
 * @date: 2017-12-25.
 */
public class ObjectMapperFactory {

  public static ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().build();

  static {
    SimpleModule module = new SimpleModule();
    module.addDeserializer(String.class, new DefaultJsonDeserializer());
    module.addSerializer(String.class, new DefaultJsonSerializer());
    mapper.registerModule(module);
  }

  public static ObjectMapper getMapper() {
    return mapper;
  }
}
