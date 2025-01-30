package com.marmouset.workout.external.database.exercise.trained;

import java.util.List;

import com.marmouset.workout.external.database.AbstractEntity;
import com.marmouset.workout.external.database.exercise.ExerciseEntity;
import com.marmouset.workout.external.database.set.ExerciseSetEntity;
import com.marmouset.workout.external.database.workout.WorkoutLogEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "trained_exercises")
public class TrainedExerciseEntity extends AbstractEntity {
  @OneToOne
  private ExerciseEntity exercise;

  @OneToMany(cascade = CascadeType.ALL)
  private List<ExerciseSetEntity> sets;

  @ManyToOne
  private WorkoutLogEntity log;

  public TrainedExerciseEntity() {
  }

  public TrainedExerciseEntity(ExerciseEntity exercise, List<ExerciseSetEntity> practices) {
    this.exercise = exercise;
    this.sets = practices;
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

  public void setPractices(List<ExerciseSetEntity> practices) {
    this.sets = practices;
  }

  public WorkoutLogEntity getLog() {
    return log;
  }

  public void setLog(WorkoutLogEntity log) {
    this.log = log;
  }

}
