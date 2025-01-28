package com.marmouset.workout.app.log;

import java.util.Arrays;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
public class WorkoutLogService {

  private final WorkoutLogRepository logRepository;
  private final Log logger = LogFactory.getLog(getClass());

  public WorkoutLogService(WorkoutLogRepository logRepository) {
    this.logRepository = logRepository;

    logger.debug("Injecting new workout logs");
    this.logRepository.saveAll(
        Arrays.asList(
            new WorkoutLog("Test"),
            new WorkoutLog("Toto")));

  }

  public Iterable<WorkoutLog> getLogs() {
    return logRepository.findAll();
  }

  public WorkoutLog getLog(UUID uuid) throws WorkoutLogNotFound {
    var logOpt = logRepository.findById(uuid);
    if (!logOpt.isPresent()) {
      throw new WorkoutLogNotFound(uuid);
    }

    return logOpt.get();
  }
}
