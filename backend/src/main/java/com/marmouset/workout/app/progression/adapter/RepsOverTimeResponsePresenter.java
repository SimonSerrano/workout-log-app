package com.marmouset.workout.app.progression.adapter;

import com.marmouset.workout.app.progression.entity.TotalNumberOfRepetitionsRecord;
import java.util.List;

public interface RepsOverTimeResponsePresenter {
  RepsOverTimeResponse present(
      String exerciseId,
      List<TotalNumberOfRepetitionsRecord> chart);
}
