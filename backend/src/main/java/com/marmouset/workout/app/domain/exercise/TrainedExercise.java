package com.marmouset.workout.app.domain.exercise;

import com.marmouset.workout.app.domain.set.ExerciseSet;
import java.util.List;

public interface TrainedExercise {

  Exercise getExercise();

  TrainedExercise setExercise(Exercise exercise);

  List<ExerciseSet> getSets();

  TrainedExercise addSet(ExerciseSet set);

  TrainedExercise removeSet(ExerciseSet set);


}
