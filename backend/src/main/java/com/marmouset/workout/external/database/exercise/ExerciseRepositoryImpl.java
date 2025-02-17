package com.marmouset.workout.external.database.exercise;

import com.marmouset.workout.app.domain.exercise.Exercise;
import com.marmouset.workout.app.port.out.exercise.CreateExerciseRepoRequest;
import com.marmouset.workout.app.port.out.exercise.ExerciseEntityContainer;
import com.marmouset.workout.app.port.out.exercise.ExerciseRepository;
import com.marmouset.workout.external.database.exception.NotFoundException;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
class ExerciseRepositoryImpl implements ExerciseRepository {

  private final JpaExerciseRepository exerciseRepository;
  private final ExerciseMapper mapper;

  public ExerciseRepositoryImpl(JpaExerciseRepository exerciseRepository,
                                ExerciseMapper mapper) {
    this.exerciseRepository = exerciseRepository;
    this.mapper = mapper;

    create(new CreateExerciseRepoRequest("Push up"));
    create(new CreateExerciseRepoRequest("Pull up"));
  }

  @Override
  public List<Exercise> read() {
    return exerciseRepository.findAll().stream().map(mapper::toExercise)
        .toList();
  }

  @Override
  public ExerciseEntityContainer readReference(UUID id)
      throws NotFoundException {
    return new ExerciseEntityContainerImpl(
        exerciseRepository.findById(id).orElseThrow(NotFoundException::new));
  }

  @Override
  public Exercise create(CreateExerciseRepoRequest request) {
    var exercise = new ExerciseEntityImpl(request.name());
    return mapper.toExercise(exerciseRepository.save(exercise));
  }

}
