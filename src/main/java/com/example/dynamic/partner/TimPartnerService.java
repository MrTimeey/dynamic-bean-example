package com.example.dynamic.partner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.text.DecimalFormat;

@Component
@ConditionalOnProperty(
      value="tom.enabled",
      havingValue = "false",
      matchIfMissing = true)
public class TimPartnerService implements PartnerService {

   private final String number = PartnerConstants.DF.format(Math.random() * 50);

   @Override
   public String getName() {
      return "Tim #" + number ;
   }

}
