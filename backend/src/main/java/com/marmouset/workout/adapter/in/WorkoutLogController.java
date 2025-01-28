package com.marmouset.workout.adapter.in;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marmouset.workout.adapter.out.dto.WorkoutLogListElementResponse;
import com.marmouset.workout.app.port.in.GetLogDetailsPort;
import com.marmouset.workout.app.port.in.ListWorkoutLogsPort;
import com.marmouset.workout.domain.WorkoutLog;
import com.marmouset.workout.domain.WorkoutLogNotFound;

@RestController
@RequestMapping("/log")
public class WorkoutLogController {

  private final ListWorkoutLogsPort listWorkoutLogsPort;
  private final GetLogDetailsPort getLogDetailsPort;

  public WorkoutLogController(ListWorkoutLogsPort listWorkoutLogsPort, GetLogDetailsPort getLogDetailsPort) {
    this.listWorkoutLogsPort = listWorkoutLogsPort;
    this.getLogDetailsPort = getLogDetailsPort;
  }

  @GetMapping
  public ResponseEntity<Iterable<WorkoutLogListElementResponse>> getLogs() {
    return ResponseEntity.ok(listWorkoutLogsPort.listWorkouts());
  }

  @GetMapping(path = "/{logId}")
  public ResponseEntity<WorkoutLog> getLog(@PathVariable UUID logId) {
    try {
      return ResponseEntity.ok(getLogDetailsPort.getDetails(logId));
    } catch (WorkoutLogNotFound e) {
      return ResponseEntity.notFound().build();
    }
  }
}
