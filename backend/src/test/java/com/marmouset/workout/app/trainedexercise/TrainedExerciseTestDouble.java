package com.marmouset.workout.app.trainedexercise;

import com.marmouset.workout.app.exercise.ExerciseTestDouble;
import com.marmouset.workout.app.exercise.entity.Exercise;
import com.marmouset.workout.app.exerciseset.entity.ExerciseSet;
import com.marmouset.workout.app.trainedexercise.entity.TrainedExercise;
import com.marmouset.workout.app.workout.WorkoutLogTestDouble;
import com.marmouset.workout.app.workout.entity.WorkoutLog;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

/**
 * Trained exercie test double with static values.
 */
public class TrainedExerciseTestDouble implements TrainedExercise {

  private final Long id = new Random().nextLong();
  private final List<ExerciseSet> sets = new ArrayList<>();
  private WorkoutLog log = new WorkoutLogTestDouble();
  private Exercise exercise = new ExerciseTestDouble();
  private Integer weight;

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public UUID getLogId() {
    return log.getId();
  }

  @Override
  public Instant getWorkoutDate() {
    return log.getCreatedAt();
  }

  @Override
  public Exercise getExercise() {
    return exercise;
  }

  @Override
  public TrainedExercise setExercise(Exercise exercise) {
    this.exercise = exercise;
    return this;
  }

  @Override
  public List<ExerciseSet> getSets() {
    return sets;
  }

  @Override
  public TrainedExercise addSet(ExerciseSet set) {
    sets.add(set);
    return this;
  }

  @Override
  public TrainedExercise addAllSets(Collection<ExerciseSet> sets) {
    this.sets.addAll(sets);
    return this;
  }

  @Override
  public TrainedExercise removeSet(ExerciseSet set) {
    sets.remove(set);
    return this;
  }

  @Override
  public Optional<Integer> getWeight() {
    return Optional.ofNullable(weight);
  }

  @Override
  public TrainedExercise setWeight(Integer weight) {
    this.weight = weight;
    return this;
  }

  @Override
  public TrainedExercise setLog(WorkoutLog log) {
    this.log = log;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    TrainedExerciseTestDouble that = (TrainedExerciseTestDouble) o;

    if (!id.equals(that.id)) {
      return false;
    }
    if (!sets.equals(that.sets)) {
      return false;
    }
    if (!Objects.equals(log, that.log)) {
      return false;
    }
    if (!Objects.equals(exercise, that.exercise)) {
      return false;
    }
    return Objects.equals(weight, that.weight);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + sets.hashCode();
    result = 31 * result + (log != null ? log.hashCode() : 0);
    result = 31 * result + (exercise != null ? exercise.hashCode() : 0);
    result = 31 * result + (weight != null ? weight.hashCode() : 0);
    return result;
  }
}
