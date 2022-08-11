package com.example.dynamic.partner;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(
      value="tom.enabled",
      havingValue = "true")
public class TomPartnerService implements PartnerService {

   private final String number = PartnerConstants.DF.format(Math.random() * 50);

   @Override
   public String getName() {
      return "Tom #" + number;
   }

}
