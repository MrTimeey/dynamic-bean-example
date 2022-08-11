package com.example.dynamic.refresh;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.endpoint.event.RefreshEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
public class RefreshController {

   private final ApplicationEventPublisher eventPublisher;
   private final PropertyChanger propertyChanger;

   @Value("${spring.config.location}")
   private String propertiesFileLocation;

   @Autowired
   public RefreshController(ApplicationEventPublisher eventPublisher, PropertyChanger propertyChanger) {
      this.eventPublisher = eventPublisher;
      this.propertyChanger = propertyChanger;
   }

   @GetMapping("/switch")
   public void change() throws IOException {
      if (propertiesFileLocation.isEmpty()) {
         return;
      }
      FileUtils.writeStringToFile(new File(propertiesFileLocation), propertyChanger.getPropertyFileText(), StandardCharsets.UTF_8);
      eventPublisher.publishEvent(new RefreshEvent(this, "RefreshEvent", "Refreshing scope"));
   }
}
