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
class WorkoutLogController {

  private final ListWorkoutLogs listWorkoutLogs;
  private final GetLogDetails getLogDetails;
  private final CreateWorkoutLog createWorkoutLog;
  private final DeleteWorkoutLog deleteWorkoutLog;
  private final WorkoutLogRequestMapper mapper;

  WorkoutLogController(ListWorkoutLogs listWorkoutLogs,
                       GetLogDetails getLogDetails,
                       CreateWorkoutLog createWorkoutLog,
                       DeleteWorkoutLog deleteWorkoutLog,
                       WorkoutLogRequestMapper mapper) {
    this.listWorkoutLogs = listWorkoutLogs;
    this.getLogDetails = getLogDetails;
    this.createWorkoutLog = createWorkoutLog;
    this.deleteWorkoutLog = deleteWorkoutLog;
    this.mapper = mapper;
  }


  @GetMapping
  public ResponseEntity<Iterable<WorkoutLogResponse>> getLogs() {
    return ResponseEntity.ok(listWorkoutLogs.list());
  }


  @GetMapping(path = "/{logId}")
  public ResponseEntity<WorkoutLogResponse> getLog(@PathVariable UUID logId) {
    try {
      return ResponseEntity.ok(getLogDetails.get(logId));
    } catch (WorkoutLogNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<WorkoutLogResponse> createLog(
      @Valid @RequestBody CreateWorkoutLogBody body) {
    return new ResponseEntity<WorkoutLogResponse>(
        createWorkoutLog.create(
            mapper.toCreateWorkoutLogCommand(body)),
        HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/{logId}")
  public ResponseEntity<Void> deleteLog(@PathVariable UUID logId) {
    deleteWorkoutLog.delete(logId);
    return ResponseEntity.noContent().build();
  }
}
