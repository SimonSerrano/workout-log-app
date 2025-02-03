package com.marmouset.workout.external.web.workout;

import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.in.workout.CreateWorkoutLog;
import com.marmouset.workout.app.port.in.workout.CreateWorkoutLogCommand;
import com.marmouset.workout.app.port.in.workout.DeleteWorkoutLog;
import com.marmouset.workout.app.port.in.workout.GetLogDetails;
import com.marmouset.workout.app.port.in.workout.ListWorkoutLogs;
import com.marmouset.workout.app.port.in.workout.UpdateWorkoutLog;
import com.marmouset.workout.app.port.in.workout.UpdateWorkoutLogCommand;
import com.marmouset.workout.app.port.out.workout.WorkoutLogResponse;
import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
  private final UpdateWorkoutLog updateWorkoutLog;

  WorkoutLogController(ListWorkoutLogs listWorkoutLogs,
                       GetLogDetails getLogDetails,
                       CreateWorkoutLog createWorkoutLog,
                       DeleteWorkoutLog deleteWorkoutLog,
                       UpdateWorkoutLog updateWorkoutLog) {
    this.listWorkoutLogs = listWorkoutLogs;
    this.getLogDetails = getLogDetails;
    this.createWorkoutLog = createWorkoutLog;
    this.deleteWorkoutLog = deleteWorkoutLog;
    this.updateWorkoutLog = updateWorkoutLog;
  }


  @GetMapping
  public ResponseEntity<Iterable<WorkoutLogResponse>> get() {
    return ResponseEntity.ok(listWorkoutLogs.list());
  }


  @GetMapping(path = "/{logId}")
  public ResponseEntity<WorkoutLogResponse> getById(@PathVariable UUID logId) {
    try {
      return ResponseEntity.ok(getLogDetails.get(logId));
    } catch (WorkoutLogNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<WorkoutLogResponse> post(
      @Valid @RequestBody CreateOrUpdateWorkoutLogBody body) {
    return new ResponseEntity<WorkoutLogResponse>(
        createWorkoutLog.create(new CreateWorkoutLogCommand(body.name())),
        HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/{logId}")
  public ResponseEntity<Void> delete(@PathVariable UUID logId) {
    deleteWorkoutLog.delete(logId);
    return ResponseEntity.noContent().build();
  }

  @PatchMapping(path = "/{logId}")
  public ResponseEntity<WorkoutLogResponse> patch(
      @PathVariable UUID logId,
      @Valid @RequestBody CreateOrUpdateWorkoutLogBody body) {
    try {
      return ResponseEntity.ok(
          updateWorkoutLog.update(
              new UpdateWorkoutLogCommand(logId, body.name())));
    } catch (WorkoutLogNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }
}
