package com.marmouset.workout.app.log;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutLogController {

  private final WorkoutLogService service;

  public WorkoutLogController(WorkoutLogService service) {
    this.service = service;
  }

  @GetMapping(path = "/log")
  public Iterable<WorkoutLog> getLogs() {
    return service.getLogs();
  }

  @GetMapping(path = "/log/{logId}")
  public ResponseEntity<WorkoutLog> getLog(@PathVariable UUID logId) {
    try {
      return ResponseEntity.ok(service.getLog(logId));
    } catch (WorkoutLogNotFound e) {
      return ResponseEntity.notFound().build();
    }
  }
}
