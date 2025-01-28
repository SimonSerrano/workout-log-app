package com.marmouset.workout.adapter.in;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marmouset.workout.adapter.in.dto.CreateWorkoutLogRequest;
import com.marmouset.workout.adapter.in.mapper.WorkoutLogRequestMapper;
import com.marmouset.workout.adapter.out.dto.WorkoutLogListElementResponse;
import com.marmouset.workout.app.port.in.CreateWorkoutLogPort;
import com.marmouset.workout.app.port.in.DeleteWorkoutLogPort;
import com.marmouset.workout.app.port.in.GetLogDetailsPort;
import com.marmouset.workout.app.port.in.ListWorkoutLogsPort;
import com.marmouset.workout.domain.WorkoutLog;
import com.marmouset.workout.domain.WorkoutLogNotFound;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/log")
public class WorkoutLogController {

  private final ListWorkoutLogsPort listWorkoutLogsPort;
  private final GetLogDetailsPort getLogDetailsPort;
  private final CreateWorkoutLogPort createWorkoutLogPort;
  private final DeleteWorkoutLogPort deleteWorkoutLogPort;
  private final WorkoutLogRequestMapper mapper;

  public WorkoutLogController(ListWorkoutLogsPort listWorkoutLogsPort, GetLogDetailsPort getLogDetailsPort,
      CreateWorkoutLogPort createWorkoutLogPort,
      com.marmouset.workout.app.port.in.DeleteWorkoutLogPort deleteWorkoutLogPort, WorkoutLogRequestMapper mapper) {
    this.listWorkoutLogsPort = listWorkoutLogsPort;
    this.getLogDetailsPort = getLogDetailsPort;
    this.createWorkoutLogPort = createWorkoutLogPort;
    this.deleteWorkoutLogPort = deleteWorkoutLogPort;
    this.mapper = mapper;
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

  @PostMapping
  public ResponseEntity<WorkoutLog> createLog(@Valid @RequestBody CreateWorkoutLogRequest request) {
    return new ResponseEntity<WorkoutLog>(
        createWorkoutLogPort.createWorkoutLog(mapper.toCreateWorkoutLogCommand(request)),
        HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/{logId}")
  public ResponseEntity<Void> deleteLog(@PathVariable UUID logId) {
    deleteWorkoutLogPort.deleteWorkoutLog(logId);
    return ResponseEntity.noContent().build();
  }
}
