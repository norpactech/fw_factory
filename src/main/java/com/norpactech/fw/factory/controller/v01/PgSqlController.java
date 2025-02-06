package com.norpactech.fw.factory.controller.v01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.norpactech.fw.factory.api.DatabaseFactoryControllerAPI;
import com.norpactech.fw.factory.domain.DatabaseFactoryAboutVO;
import com.norpactech.fw.factory.service.PgSqlDatabaseFactoryService;

@RestController
@RequestMapping("/pgsql/v01")
public class PgSqlController implements DatabaseFactoryControllerAPI {

  @Autowired
  PgSqlDatabaseFactoryService factoryService;

  @Override
  @GetMapping("/about")
  public DatabaseFactoryAboutVO getAbout() {

    return new DatabaseFactoryAboutVO(
      factoryService.getFactoryName(), 
      factoryService.getFactoryVersion(),
      factoryService.getDatabaseSchema());
  }
}