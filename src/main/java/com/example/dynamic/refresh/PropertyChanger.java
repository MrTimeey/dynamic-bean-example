package com.example.dynamic.refresh;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class PropertyChanger {

   @Value("${tom.enabled}")
   private String tomEnabled;

   public String getPropertyFileText() {
      return "tom.enabled=" + ("true".equals(tomEnabled) ? "false" : "true");
   }
}
