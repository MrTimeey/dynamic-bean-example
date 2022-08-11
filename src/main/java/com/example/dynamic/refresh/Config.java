package com.example.dynamic.refresh;

import com.example.dynamic.partner.PartnerService;
import com.example.dynamic.partner.TimPartnerService;
import com.example.dynamic.partner.TomPartnerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
@RefreshScope
public class Config {

   @Value("${tom.enabled}")
   private String tomEnabled;

   @Bean
   @RequestScope
   public PartnerService partnerService() {
      if ("true".equals(tomEnabled)) {
         return new TomPartnerService();
      }
      return new TimPartnerService();
   }

}
