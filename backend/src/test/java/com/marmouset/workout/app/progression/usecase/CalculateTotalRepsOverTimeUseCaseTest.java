//package com.marmouset.workout.app.progression.usecase;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import com.marmouset.workout.app.exercise.usecase.ExerciseRepository;
//import com.marmouset.workout.app.exercise.entity.ExerciseFactory;
//import com.marmouset.workout.app.exercise.adapter.dto.ExerciseResponse;
//import com.marmouset.workout.app.exercise.usecase.exception.ExerciseNotFoundException;
//import com.marmouset.workout.app.progression.entity.TotalNumberOfRepetitionsRecordFactory;
//import com.marmouset.workout.app.progression.entity.impl.TotalNumberOfRepetitionsRecordImpl;
//import com.marmouset.workout.app.progression.usecase.dto.CalculateTotalRepsOverTimeCommand;
//import com.marmouset.workout.app.progression.adapter.dto.RepsOverTimeRecordResponseImpl;
//import com.marmouset.workout.app.progression.adapter.dto.RepsOverTimeResponseImpl;
//import com.marmouset.workout.app.progression.adapter.RepsOverTimeResponsePresenter;
//import com.marmouset.workout.app.set.entity.ExerciseSet;
//import com.marmouset.workout.app.set.entity.ExerciseSetFactory;
//import com.marmouset.workout.app.shared.external.database.exception.NotFoundException;
//import com.marmouset.workout.app.trainedexercise.entity.TrainedExercise;
//import com.marmouset.workout.app.trainedexercise.entity.TrainedExerciseFactory;
//import com.marmouset.workout.app.trainedexercise.usecase.dto.GetTrainedExerciseByExerciseIdRepoRequest;
//import com.marmouset.workout.app.trainedexercise.usecase.TrainedExerciseRepository;
//import java.time.Instant;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//import java.util.List;
//import java.util.Random;
//import java.util.UUID;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//
//@SpringBootTest
//public class CalculateTotalRepsOverTimeUseCaseTest {
//
//  @MockitoBean
//  private TrainedExerciseRepository trainedExerciseRepository;
//
//  @MockitoBean
//  private ExerciseRepository exerciseRepository;
//
//  @Autowired
//  private TrainedExerciseFactory trainedExerciseFactory;
//  @Autowired
//  private ExerciseFactory exerciseFactory;
//  @Autowired
//  private ExerciseSetFactory exerciseSetFactory;
//  @Autowired
//  private TotalNumberOfRepetitionsRecordFactory
//      totalNumberOfRepetitionsRecordFactory;
//
//  @Autowired
//  private RepsOverTimeResponsePresenter presenter;
//
//  private CalculateTotalRepsOverTimeUseCase useCase;
//
//
//  @BeforeEach
//  void setUp() {
//    useCase = new CalculateTotalRepsOverTimeUseCase(
//        exerciseRepository,
//        trainedExerciseRepository,
//        totalNumberOfRepetitionsRecordFactory,
//        presenter);
//  }
//
//  @Test
//  void shouldReturnCalculatedTotalRepetitionsOverTime()
//      throws NotFoundException, ExerciseNotFoundException {
//    var expected = new RepsOverTimeResponseImpl(
//        new ExerciseResponse("Pull ups"),
//        List.of(
//            createRecordResponse(10, 24),
//            createRecordResponse(12, 28),
//            createRecordResponse(14, 32)
//        )
//    );
//    when(exerciseRepository.readReference("Pull ups"))
//        .thenReturn(() -> null);
//    when(trainedExerciseRepository.getTrainedExerciseByExerciseId(
//        new GetTrainedExerciseByExerciseIdRepoRequest(() -> null)))
//        .thenReturn(List.of(
//            createTrainedExercise(8, 8),
//            createTrainedExercise(8, 10),
//            createTrainedExercise(10, 12)
//        ));
//
//    assertEquals(
//        expected,
//        useCase.calculate(new CalculateTotalRepsOverTimeCommand("Pull ups")));
//  }
//
//  private TrainedExercise createTrainedExercise(int firstTwoSets, int lastSet) {
//    return trainedExerciseFactory.create(
//        new Random().nextLong(), UUID.randomUUID(),
//        exerciseFactory.create("Pull ups")
//    ).addAllSets(
//        createListOfExerciseSet(List.of(firstTwoSets, firstTwoSets, lastSet)));
//  }
//
//  private List<ExerciseSet> createListOfExerciseSet(List<Integer> reps) {
//    return reps.stream()
//        .map((rep) -> exerciseSetFactory
//            .create(new Random().nextLong(), rep))
//        .toList();
//
//  }
//
//  private TotalNumberOfRepetitionsRecordImpl createRecord(
//      int dayOfMonth,
//      int reps) {
//    return new TotalNumberOfRepetitionsRecordImpl(
//        getInstantForDate(dayOfMonth),
//        reps);
//  }
//
//  private RepsOverTimeRecordResponseImpl createRecordResponse(
//      int dayOfMonth, int reps) {
//    return new RepsOverTimeRecordResponseImpl(
//        getInstantForDate(dayOfMonth).getEpochSecond(),
//        reps
//    );
//  }
//
//  private Instant getInstantForDate(int dayOfMonth) {
//    return new GregorianCalendar(2024, Calendar.SEPTEMBER, dayOfMonth)
//        .toInstant();
//  }
//}
