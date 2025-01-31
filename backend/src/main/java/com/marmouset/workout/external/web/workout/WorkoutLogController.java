package com.marmouset.workout.external.web.workout;

import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.in.workout.CreateWorkoutLog;
import com.marmouset.workout.app.port.in.workout.DeleteWorkoutLog;
import com.marmouset.workout.app.port.in.workout.GetLogDetails;
import com.marmouset.workout.app.port.in.workout.ListWorkoutLogs;
import com.marmouset.workout.app.port.out.workout.WorkoutLogResponse;
import jakarta.validation.Valid;
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

@RestController
@RequestMapping("/log")
public class WorkoutLogController {

  private final ListWorkoutLogs listWorkoutLogsPort;
  private final GetLogDetails getLogDetailsPort;
  private final CreateWorkoutLog createWorkoutLogPort;
  private final DeleteWorkoutLog deleteWorkoutLogPort;
  private final WorkoutLogRequestMapper mapper;

  public WorkoutLogController(ListWorkoutLogs listWorkoutLogsPort,
                              GetLogDetails getLogDetailsPort,
                              CreateWorkoutLog createWorkoutLogPort,
                              DeleteWorkoutLog deleteWorkoutLogPort,
                              WorkoutLogRequestMapper mapper) {
    this.listWorkoutLogsPort = listWorkoutLogsPort;
    this.getLogDetailsPort = getLogDetailsPort;
    this.createWorkoutLogPort = createWorkoutLogPort;
    this.deleteWorkoutLogPort = deleteWorkoutLogPort;
    this.mapper = mapper;
  }

  @GetMapping
  public ResponseEntity<Iterable<WorkoutLogResponse>> getLogs() {
    return ResponseEntity.ok(listWorkoutLogsPort.listWorkouts());
  }

  @GetMapping(path = "/{logId}")
  public ResponseEntity<WorkoutLogResponse> getLog(@PathVariable UUID logId) {
    try {
      return ResponseEntity.ok(getLogDetailsPort.getDetails(logId));
    } catch (WorkoutLogNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<WorkoutLogResponse> createLog(
      @Valid @RequestBody CreateWorkoutLogRequest request) {
    return new ResponseEntity<WorkoutLogResponse>(
        createWorkoutLogPort.createWorkoutLog(
            mapper.toCreateWorkoutLogCommand(request)),
        HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/{logId}")
  public ResponseEntity<Void> deleteLog(@PathVariable UUID logId) {
    deleteWorkoutLogPort.deleteWorkoutLog(logId);
    return ResponseEntity.noContent().build();
  }
}
