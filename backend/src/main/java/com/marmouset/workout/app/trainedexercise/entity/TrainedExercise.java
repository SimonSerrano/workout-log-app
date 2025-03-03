package com.marmouset.workout.app.trainedexercise.entity;

import com.marmouset.workout.app.exercise.entity.Exercise;
import com.marmouset.workout.app.exerciseset.entity.ExerciseSet;
import com.marmouset.workout.app.shared.entity.Entity;
import com.marmouset.workout.app.workout.entity.WorkoutLog;
import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Interface for the trained exerciseContainer entity.
 */
public interface TrainedExercise extends Entity<Long> {

  /**
   * Get the logContainer id.
   *
   * @return the logContainer id
   */
  UUID getLogId();

  /**
   * Get the workout date.
   *
   * @return the workout date
   */
  Instant getWorkoutDate();

  /**
   * Get the trained exerciseContainer.
   *
   * @return the exerciseContainer
   */
  Exercise getExercise();

  /**
   * Set the trained exerciseContainer.
   *
   * @param exercise the exerciseContainer
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
   * Sets the sets.
   *
   * @param sets the sets
   * @return this
   */
  TrainedExercise setSets(Collection<ExerciseSet> sets);

  /**
   * Add a trained set.
   *
   * @param set the set to add
   * @return this
   */
  TrainedExercise addSet(ExerciseSet set);

  /**
   * Adds all sets.
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

  /**
   * Get the optional weight.
   *
   * @return the weight wrapped in an optional
   */
  Optional<Integer> getWeight();

  /**
   * Set the weight.
   *
   * @param weight the weight to set
   * @return this
   */
  TrainedExercise setWeight(Integer weight);

  /**
   * Sets the workout log that trained exercise belongs to.
   *
   * @param log the workout log
   * @return this
   */
  TrainedExercise setLog(WorkoutLog log);

}
