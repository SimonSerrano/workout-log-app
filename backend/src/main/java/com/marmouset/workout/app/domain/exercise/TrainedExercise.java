package com.marmouset.workout.app.domain.exercise;

import com.marmouset.workout.app.domain.set.ExerciseSet;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * Interface for the trained exercise entity.
 */
public interface TrainedExercise {

  /**
   * Get the id.
   *
   * @return the id
   */
  UUID getId();

  /**
   * Get the trained exercise.
   *
   * @return the exercise
   */
  Exercise getExercise();

  /**
   * Set the trained exercise.
   *
   * @param exercise the exercise
   * @return this
   */
  TrainedExercise setExercise(Exercise exercise);

  /**
   * Get the sets.
   *
   * @return the sets
   */
  List<ExerciseSet> getSets();

  /**
   * Add a trained set.
   *
   * @param set the set to add
   * @return this
   */
  TrainedExercise addSet(ExerciseSet set);

  /**
   * Adds all sets
   *
   * @param sets the sets to add
   * @return this
   */
  TrainedExercise addAllSets(Collection<ExerciseSet> sets);

  /**
   * Remove a set.
   *
   * @param set the set to remove
   * @return this
   */
  TrainedExercise removeSet(ExerciseSet set);


}
