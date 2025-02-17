package com.marmouset.workout.external.database.exercise.trained;

import com.marmouset.workout.app.port.out.exercise.ExerciseEntity;
import com.marmouset.workout.app.port.out.workout.WorkoutLogEntity;
import com.marmouset.workout.external.database.AbstractEntity;
import com.marmouset.workout.external.database.exercise.ExerciseEntityImpl;
import com.marmouset.workout.external.database.set.ExerciseSetEntity;
import com.marmouset.workout.external.database.workout.WorkoutLogEntityImpl;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;

/**
 * This class represents a trained exerciseContainer in the database.
 */
@Entity
@Table(name = "trained_exercises")
public class TrainedExerciseEntity extends AbstractEntity {

  @EmbeddedId
  private TrainedExercisePrimaryKey id;

  @OneToOne(targetEntity = ExerciseEntityImpl.class)
  private ExerciseEntity exercise;

  @OneToMany(cascade = CascadeType.ALL)
  private List<ExerciseSetEntity> sets;

  @OneToOne(targetEntity = WorkoutLogEntityImpl.class)
  @JoinColumn(insertable = false, updatable = false)
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

  public TrainedExercisePrimaryKey getId() {
    return id;
  }

  public TrainedExerciseEntity setId(
      TrainedExercisePrimaryKey id) {
    this.id = id;
    return this;
  }
}
