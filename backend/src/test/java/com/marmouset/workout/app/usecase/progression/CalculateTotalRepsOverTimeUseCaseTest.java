package com.marmouset.workout.app.usecase.progression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.domain.exercise.ExerciseFactory;
import com.marmouset.workout.app.domain.exercise.ExerciseNotFoundException;
import com.marmouset.workout.app.domain.exercise.TrainedExercise;
import com.marmouset.workout.app.domain.exercise.TrainedExerciseFactory;
import com.marmouset.workout.app.domain.progression.TotalNumberOfRepetitionsRecordFactory;
import com.marmouset.workout.app.domain.progression.impl.TotalNumberOfRepetitionsRecordImpl;
import com.marmouset.workout.app.domain.set.ExerciseSet;
import com.marmouset.workout.app.domain.set.ExerciseSetFactory;
import com.marmouset.workout.app.port.in.progression.CalculateTotalRepsOverTimeCommand;
import com.marmouset.workout.app.port.out.exercise.ExerciseRepository;
import com.marmouset.workout.app.port.out.exercise.ExerciseResponse;
import com.marmouset.workout.app.port.out.exercise.trained.GetTrainedExerciseByExerciseIdRepoRequest;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseRepository;
import com.marmouset.workout.app.port.out.progression.RepsOverTimeRecordResponseImpl;
import com.marmouset.workout.app.port.out.progression.RepsOverTimeResponseImpl;
import com.marmouset.workout.app.port.out.progression.RepsOverTimeResponsePresenter;
import com.marmouset.workout.external.database.exception.NotFoundException;
import java.time.Instant;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
public class CalculateTotalRepsOverTimeUseCaseTest {

  @MockitoBean
  private TrainedExerciseRepository trainedExerciseRepository;

  @MockitoBean
  private ExerciseRepository exerciseRepository;

  @Autowired
  private TrainedExerciseFactory trainedExerciseFactory;
  @Autowired
  private ExerciseFactory exerciseFactory;
  @Autowired
  private ExerciseSetFactory exerciseSetFactory;
  @Autowired
  private TotalNumberOfRepetitionsRecordFactory
      totalNumberOfRepetitionsRecordFactory;

  @Autowired
  private RepsOverTimeResponsePresenter presenter;

  private CalculateTotalRepsOverTimeUseCase useCase;


  @BeforeEach
  void setUp() {
    useCase = new CalculateTotalRepsOverTimeUseCase(
        exerciseRepository,
        trainedExerciseRepository,
        totalNumberOfRepetitionsRecordFactory,
        presenter);
  }

  @Test
  void shouldReturnCalculatedTotalRepetitionsOverTime()
      throws NotFoundException, ExerciseNotFoundException {
    var expected = new RepsOverTimeResponseImpl(
        new ExerciseResponse("Pull ups"),
        List.of(
            createRecordResponse(10, 24),
            createRecordResponse(12, 28),
            createRecordResponse(14, 32)
        )
    );
    when(exerciseRepository.readReference("Pull ups"))
        .thenReturn(() -> null);
    when(trainedExerciseRepository.getTrainedExerciseByExerciseId(
        new GetTrainedExerciseByExerciseIdRepoRequest(() -> null)))
        .thenReturn(List.of(
            createTrainedExercise(8, 8),
            createTrainedExercise(8, 10),
            createTrainedExercise(10, 12)
        ));

    assertEquals(
        expected,
        useCase.calculate(new CalculateTotalRepsOverTimeCommand("Pull ups")));
  }

  private TrainedExercise createTrainedExercise(int firstTwoSets, int lastSet) {
    return trainedExerciseFactory.create(
        new Random().nextLong(), UUID.randomUUID(),
        exerciseFactory.create("Pull ups")
    ).addAllSets(
        createListOfExerciseSet(List.of(firstTwoSets, firstTwoSets, lastSet)));
  }

  private List<ExerciseSet> createListOfExerciseSet(List<Integer> reps) {
    return reps.stream()
        .map((rep) -> exerciseSetFactory
            .create(new Random().nextLong(), rep))
        .toList();

  }

  private TotalNumberOfRepetitionsRecordImpl createRecord(
      int dayOfMonth,
      int reps) {
    return new TotalNumberOfRepetitionsRecordImpl(
        getInstantForDate(dayOfMonth),
        reps);
  }

  private RepsOverTimeRecordResponseImpl createRecordResponse(
      int dayOfMonth, int reps) {
    return new RepsOverTimeRecordResponseImpl(
        getInstantForDate(dayOfMonth).getEpochSecond(),
        reps
    );
  }

  private Instant getInstantForDate(int dayOfMonth) {
    return new GregorianCalendar(2024, Calendar.SEPTEMBER, dayOfMonth)
        .toInstant();
  }
}
