package com.marmouset.workout.external.database.exercise.trained;

import com.marmouset.workout.app.port.out.exercise.ExerciseEntity;
import com.marmouset.workout.app.port.out.exercise.trained.CreateTrainedExerciseRepoRequest;
import com.marmouset.workout.app.port.out.exercise.trained.UpdateTrainedExerciseRepoRequest;
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
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a trained exerciseContainer in the database.
 */
@Entity
@Table(name = "trained_exercises")
public class TrainedExerciseEntity extends AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(targetEntity = ExerciseEntityImpl.class)
  private ExerciseEntity exercise;

  @OneToMany(cascade = CascadeType.ALL)
  private List<ExerciseSetEntity> sets;

  @ManyToOne(fetch = FetchType.LAZY, targetEntity = WorkoutLogEntityImpl.class)
  @JoinColumn(name = "log.id", updatable = false)
  private WorkoutLogEntity log;

  @Min(0)
  private Integer weight;

  TrainedExerciseEntity() {
    sets = new ArrayList<>();
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

  /**
   * Replace all sets with new sets.
   *
   * @param sets the sets to set
   */
  public void setSets(List<ExerciseSetEntity> sets) {
    this.sets.clear();
    this.sets.addAll(sets);
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

  public float getWeight() {
    return weight;
  }

  /**
   * Sets the weight.
   *
   * @param weight the weight to set
   * @return this
   */
  public TrainedExerciseEntity setWeight(Integer weight) {
    this.weight = weight;
    return this;
  }

  /**
   * Mutates this entity from a creation request.
   *
   * @param request the mutation request
   * @return this
   */
  public TrainedExerciseEntity mutateFrom(
      CreateTrainedExerciseRepoRequest request) {
    setExercise(request.exerciseContainer().reference());
    setLog(request.logContainer().reference());
    setSets(request.sets().stream().map(
        this::createExerciseSetEntity).toList());
    setWeight(request.weight());
    return this;
  }

  /**
   * Mutates this entity from an update request.
   *
   * @param request the mutation request
   * @return this
   */
  public TrainedExerciseEntity mutateFrom(
      UpdateTrainedExerciseRepoRequest request) {
    setExercise(request.exerciseContainer().reference());
    setSets(
        request.sets().stream().map(this::createExerciseSetEntity).toList());
    setWeight(request.weight());
    return this;
  }

  private ExerciseSetEntity createExerciseSetEntity(Integer s) {
    var setEntity = new ExerciseSetEntity();
    setEntity.setReps(s);
    return setEntity;
  }
}
