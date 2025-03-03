package com.marmouset.workout.app.trainedexercise.external.spring.database;

import com.marmouset.workout.app.exercise.entity.Exercise;
import com.marmouset.workout.app.exercise.external.spring.database.ExerciseImpl;
import com.marmouset.workout.app.exerciseset.entity.ExerciseSet;
import com.marmouset.workout.app.exerciseset.external.spring.database.ExerciseSetImpl;
import com.marmouset.workout.app.shared.external.database.AbstractEntity;
import com.marmouset.workout.app.trainedexercise.entity.TrainedExercise;
import com.marmouset.workout.app.workout.entity.WorkoutLog;
import com.marmouset.workout.app.workout.external.spring.database.WorkoutLogImpl;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This class represents a trained exerciseContainer in the database.
 */
@Entity
@Table(name = "trained_exercises")
public class TrainedExerciseImpl extends AbstractEntity implements
    TrainedExercise {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(targetEntity = ExerciseImpl.class)
  private Exercise exercise;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = ExerciseSetImpl.class)
  @JoinTable(name = "trained_exercises_sets", joinColumns = @JoinColumn(name = "trained_exercise_id"), inverseJoinColumns = @JoinColumn(name = "sets_id"))
  private List<ExerciseSet> sets;

  @ManyToOne(fetch = FetchType.LAZY, targetEntity = WorkoutLogImpl.class)
  @JoinColumn(name = "log.id", updatable = false)
  private WorkoutLog log;

  @Min(0)
  private Integer weight;

  TrainedExerciseImpl() {
    sets = new ArrayList<>();
  }

  @Override
  public UUID getLogId() {
    return log.getId();
  }

  @Override
  public Instant getWorkoutDate() {
    return null;
  }

  @Override
  public Exercise getExercise() {
    return exercise;
  }

  /**
   * Set the exercise.
   *
   * @param exercise the exercise
   * @return this
   */
  public TrainedExercise setExercise(Exercise exercise) {
    this.exercise = exercise;
    return this;
  }

  @Override
  public List<ExerciseSet> getSets() {
    return sets;
  }

  @Override
  public TrainedExercise setSets(Collection<ExerciseSet> sets) {
    this.sets.clear();
    this.sets.addAll(sets);
    return this;
  }

  @Override
  public TrainedExercise addSet(ExerciseSet set) {
    sets.add(set);
    return this;
  }

  @Override
  public TrainedExercise addAllSets(Collection<ExerciseSet> sets) {
    sets.addAll(sets);
    return this;
  }

  @Override
  public TrainedExercise removeSet(ExerciseSet set) {
    sets.remove(set);
    return this;
  }

  public WorkoutLog getLog() {
    return log;
  }

  @Override
  public TrainedExercise setLog(WorkoutLog log) {
    this.log = log;
    return this;
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public Optional<Integer> getWeight() {
    return Optional.ofNullable(weight);
  }

  /**
   * Sets the weight.
   *
   * @param weight the weight to set
   * @return this
   */
  public TrainedExercise setWeight(Integer weight) {
    this.weight = weight;
    return this;
  }

}
