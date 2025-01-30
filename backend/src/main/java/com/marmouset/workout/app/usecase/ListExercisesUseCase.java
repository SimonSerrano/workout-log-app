package com.marmouset.workout.app.usecase;

import java.util.stream.StreamSupport;

import org.springframework.stereotype.Component;

import com.marmouset.workout.app.port.in.ListExercises;
import com.marmouset.workout.app.port.out.ExercisePresenter;
import com.marmouset.workout.app.port.out.ExerciseRepository;
import com.marmouset.workout.app.port.out.dto.ExerciseResponse;

@Component
public class ListExercisesUseCase implements ListExercises {

  private final ExerciseRepository exerciseRepositoryPort;
  private final ExercisePresenter presenter;

  public ListExercisesUseCase(ExerciseRepository exerciseRepositoryPort, ExercisePresenter presenter) {
    this.exerciseRepositoryPort = exerciseRepositoryPort;
    this.presenter = presenter;
  }

  @Override
  public Iterable<ExerciseResponse> listExercises() {
    return StreamSupport.stream(exerciseRepositoryPort.getExercises().spliterator(), false)
        .map(presenter::prepareResponse).toList();
  }

}
