package com.marmouset.workout.external.database.exercise.trained;

import com.marmouset.workout.app.port.out.exercise.ExerciseEntity;
import com.marmouset.workout.app.port.out.workout.WorkoutLogEntity;
import com.marmouset.workout.external.database.AbstractEntity;
import com.marmouset.workout.external.database.exercise.ExerciseEntityImpl;
import com.marmouset.workout.external.database.set.ExerciseSetEntity;
import com.marmouset.workout.external.database.workout.WorkoutLogEntityImpl;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToOne(targetEntity = ExerciseEntityImpl.class)
  private ExerciseEntity exercise;

  @OneToMany(cascade = CascadeType.ALL)
  private List<ExerciseSetEntity> sets;

  @ManyToOne(fetch = FetchType.LAZY, targetEntity = WorkoutLogEntityImpl.class)
  @JoinColumn(name = "log.id", updatable = false)
  private WorkoutLogEntity log;

  TrainedExerciseEntity() {
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

  public Long getId() {
    return id;
  }

  /**
   * Sets the id.
   * For tests only
   *
   * @param id the id to set
   * @return this
   */
  public TrainedExerciseEntity TEST_ONLY_setId(
      Long id) {
    this.id = id;
    return this;
  }
}
