package com.excel.read;

import com.excel.read.service.ReadService;
import com.excel.read.service.WriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RunAfterStartup {


  @Autowired
  ReadService readService;

  @Autowired
  WriteService writeService;

  @EventListener(ApplicationReadyEvent.class)
  public void runAfterStartup() {
    System.out.println("Reading........");
    readService.readExcel();
    System.out.println("Writing........");
    writeService.writeExcel();
    System.out.println("Completed");

  }
}