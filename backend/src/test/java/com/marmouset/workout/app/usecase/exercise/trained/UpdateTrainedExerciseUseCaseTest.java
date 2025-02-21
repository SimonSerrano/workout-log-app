package com.marmouset.workout.app.usecase.exercise.trained;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.domain.exercise.ExerciseFactory;
import com.marmouset.workout.app.domain.exercise.ExerciseNotFoundException;
import com.marmouset.workout.app.domain.exercise.TrainedExerciseFactory;
import com.marmouset.workout.app.domain.workout.WorkoutLogFactory;
import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.in.exercise.UpdatedTrainedExerciseCommandBuilder;
import com.marmouset.workout.app.port.out.exercise.ExerciseEntity;
import com.marmouset.workout.app.port.out.exercise.ExerciseEntityContainer;
import com.marmouset.workout.app.port.out.exercise.ExerciseRepository;
import com.marmouset.workout.app.port.out.exercise.ExerciseResponse;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExercisePresenter;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponseBuilder;
import com.marmouset.workout.app.port.out.exercise.trained.UpdateTrainedExerciseRepoRequest;
import com.marmouset.workout.app.port.out.workout.WorkoutLogRepository;
import com.marmouset.workout.external.database.exception.NotFoundException;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class UpdateTrainedExerciseUseCaseTest {

  @MockitoBean
  private TrainedExerciseRepository trainedExerciseRepository;
  @MockitoBean
  private WorkoutLogRepository workoutLogRepository;
  @MockitoBean
  private ExerciseRepository exerciseRepository;

  @Autowired
  private TrainedExercisePresenter presenter;

  @Autowired
  private WorkoutLogFactory workoutLogFactory;
  @Autowired
  private ExerciseFactory exerciseFactory;
  @Autowired
  private TrainedExerciseFactory trainedExerciseFactory;
  private UpdateTrainedExerciseUseCase useCase;

  @BeforeEach
  void setUp() {
    useCase = new UpdateTrainedExerciseUseCase(
        trainedExerciseRepository,
        workoutLogRepository,
        exerciseRepository,
        presenter);
  }

  @Test
  void shouldCallRepositoryToUpdateTrainedExercise()
      throws NotFoundException, WorkoutLogNotFoundException,
      ExerciseNotFoundException {
    var workout = workoutLogFactory.create(UUID.randomUUID(), "Toto", Instant.now());
    var exercise = exerciseFactory.create("Pull up");
    var trainedId = 8L;
    var expected = new TrainedExerciseResponseBuilder().setId(trainedId)
        .setLogId(workout.getId())
        .setExercise(new ExerciseResponse(exercise.name()))
        .setSets(Collections.emptyList())
        .build();

    ExerciseEntityContainer exerciseContainer = () -> new ExerciseEntity() {
      @Override
      public String getName() {
        return exercise.name();
      }

      @Override
      public String getId() {
        return exercise.name();
      }
    };

    when(workoutLogRepository.exists(expected.logId()))
        .thenReturn(true);
    when(exerciseRepository.readReference(exercise.name()))
        .thenReturn(exerciseContainer);
    when(trainedExerciseRepository
        .update(
            new UpdateTrainedExerciseRepoRequest(trainedId,
                exerciseContainer, List.of(8, 8, 7))))
        .thenReturn(trainedExerciseFactory
            .create(trainedId, workout.getId(), exercise));

    var result = useCase.update(
        new UpdatedTrainedExerciseCommandBuilder().setTrainedId(expected.id())
            .setLogId(workout.getId()).setExerciseId(expected.exercise().name())
            .setSets(List.of(8, 8, 7)).build());
    assertEquals(expected, result);

  }
}