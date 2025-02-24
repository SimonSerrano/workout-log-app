package com.marmouset.workout.app.port.out.progression;

import com.marmouset.workout.app.domain.progression.TotalNumberOfRepetitionsRecord;
import java.util.List;

public interface RepsOverTimeResponsePresenter {
  RepsOverTimeResponse present(
      String exerciseId,
      List<TotalNumberOfRepetitionsRecord> chart);
}
