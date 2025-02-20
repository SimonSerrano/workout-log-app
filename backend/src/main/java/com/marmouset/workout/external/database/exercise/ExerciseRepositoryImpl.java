package com.marmouset.workout.external.database.exercise;

import com.marmouset.workout.app.domain.exercise.Exercise;
import com.marmouset.workout.app.port.out.exercise.CreateExerciseRepoRequest;
import com.marmouset.workout.app.port.out.exercise.ExerciseEntityContainer;
import com.marmouset.workout.app.port.out.exercise.ExerciseRepository;
import com.marmouset.workout.external.database.exception.NotFoundException;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
class ExerciseRepositoryImpl implements ExerciseRepository {

  private final JpaExerciseRepository exerciseRepository;
  private final ExerciseMapper mapper;

  public ExerciseRepositoryImpl(JpaExerciseRepository exerciseRepository,
                                ExerciseMapper mapper) {
    this.exerciseRepository = exerciseRepository;
    this.mapper = mapper;

 
  }

  @Override
  public List<Exercise> read() {
    return exerciseRepository.findAll().stream().map(mapper::toExercise)
        .toList();
  }

  @Override
  public ExerciseEntityContainer readReference(String id)
      throws NotFoundException {
    try {
      return new ExerciseEntityContainerImpl(
          exerciseRepository.getReferenceById(id));
    } catch (EntityNotFoundException e) {
      throw new NotFoundException();
    }
  }

  @Override
  public Exercise create(CreateExerciseRepoRequest request) {
    var exercise = new ExerciseEntityImpl(request.name());
    return mapper.toExercise(exerciseRepository.save(exercise));
  }

}
