package com.epam.yoke.notify.controller;

import com.epam.yoke.notify.model.Report;
import com.epam.yoke.notify.service.ReportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/report")
@RestController
public class ReportController {

  @Autowired
  private ReportService reportService;

  @GetMapping("/{id}")
  public @ResponseBody
  Report getReport(@PathVariable String id) {
    return reportService.getReport(id);
  }

  @GetMapping("/")
  public @ResponseBody
  List<Report> getReport() {
    return reportService.getReports();
  }
}
