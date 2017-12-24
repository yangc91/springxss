package com.yc.learn.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.HtmlUtils;

/**
 * String类型的json反序列化处理器
 * @author: yc
 * @date: 2017-12-15.
 */
public class DefaultJsonDeserializer extends StdDeserializer<String> {

  public DefaultJsonDeserializer() {
    this(null);
  }

  public DefaultJsonDeserializer(Class<String> t) {
    super(t);
  }

  @Override
  public String deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException {
    String value = p.getValueAsString();
    if (StringUtils.isEmpty(value)) {
      return value;
    } else {
      value = HtmlUtils.htmlEscape(value.toString(), "utf-8");
      return value;
    }
  }
}
