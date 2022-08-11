package com.example.dynamic.partner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PartnerController {

   private final PartnerService partnerService;

   @Autowired
   public PartnerController(PartnerService partnerService) {
      this.partnerService = partnerService;
   }

   @GetMapping("/")
   public List<String> partners() {
      return List.of(partnerService.getName());
   }
}
