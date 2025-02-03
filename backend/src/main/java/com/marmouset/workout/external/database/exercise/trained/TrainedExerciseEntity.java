package com.marmouset.workout.external.database.exercise.trained;

import com.marmouset.workout.external.database.UuidBasedAbstractEntity;
import com.marmouset.workout.external.database.exercise.ExerciseEntity;
import com.marmouset.workout.external.database.set.ExerciseSetEntity;
import com.marmouset.workout.external.database.workout.WorkoutLogEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;

/**
 * This class represents a trained exercise in the database.
 */
@Entity
@Table(name = "trained_exercises")
public class TrainedExerciseEntity extends UuidBasedAbstractEntity {
  @OneToOne
  private ExerciseEntity exercise;

  @OneToMany(cascade = CascadeType.ALL)
  private List<ExerciseSetEntity> sets;

  @OneToOne
  private WorkoutLogEntity log;

  TrainedExerciseEntity() {
  }

  TrainedExerciseEntity(ExerciseEntity exercise, List<ExerciseSetEntity> sets) {
    this.exercise = exercise;
    this.sets = sets;
  }

  public ExerciseEntity getExercise() {
    return exercise;
  }

  public void setExercise(ExerciseEntity exercise) {
    this.exercise = exercise;
  }

  public List<ExerciseSetEntity> getSets() {
    return sets;
  }

  public void setSets(List<ExerciseSetEntity> sets) {
    this.sets = sets;
  }

  public WorkoutLogEntity getLog() {
    return log;
  }

  public void setLog(WorkoutLogEntity log) {
    this.log = log;
  }

}
