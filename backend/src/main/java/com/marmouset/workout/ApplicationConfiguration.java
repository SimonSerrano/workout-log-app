package com.marmouset.workout;

import com.marmouset.workout.app.exercise.adapter.ExerciseController;
import com.marmouset.workout.app.exercise.adapter.ExerciseRepositoryGateway;
import com.marmouset.workout.app.exercise.adapter.impl.ExerciseControllerImpl;
import com.marmouset.workout.app.exercise.adapter.impl.ExerciseRepositoryImpl;
import com.marmouset.workout.app.exercise.entity.ExerciseFactory;
import com.marmouset.workout.app.exercise.external.spring.database.ExerciseFactoryImpl;
import com.marmouset.workout.app.exercise.usecase.ExerciseRepository;
import com.marmouset.workout.app.exercise.usecase.ListExercisesUseCase;
import com.marmouset.workout.app.exercise.usecase.impl.ListExercisesUseCaseImpl;
import com.marmouset.workout.app.exerciseset.entity.ExerciseSetFactory;
import com.marmouset.workout.app.exerciseset.external.spring.database.ExerciseSetFactoryImpl;
import com.marmouset.workout.app.progression.adapter.ProgressionController;
import com.marmouset.workout.app.progression.adapter.impl.ProgressionControllerImpl;
import com.marmouset.workout.app.progression.usecase.CalculateRepsProgressionChartUseCase;
import com.marmouset.workout.app.progression.usecase.impl.CalculateRepsProgressionChartUseCaseImpl;
import com.marmouset.workout.app.trainedexercise.adapter.TrainedExerciseController;
import com.marmouset.workout.app.trainedexercise.adapter.TrainedExerciseRepositoryGateway;
import com.marmouset.workout.app.trainedexercise.adapter.impl.TrainedExerciseControllerImpl;
import com.marmouset.workout.app.trainedexercise.adapter.impl.TrainedExerciseRepositoryImpl;
import com.marmouset.workout.app.trainedexercise.entity.TrainedExerciseFactory;
import com.marmouset.workout.app.trainedexercise.external.spring.database.TrainedExerciseFactoryImpl;
import com.marmouset.workout.app.trainedexercise.usecase.CreateTrainedExerciseUseCase;
import com.marmouset.workout.app.trainedexercise.usecase.DeleteTrainedExerciseUseCase;
import com.marmouset.workout.app.trainedexercise.usecase.ListTrainedExercisesUseCase;
import com.marmouset.workout.app.trainedexercise.usecase.TrainedExerciseRepository;
import com.marmouset.workout.app.trainedexercise.usecase.UpdateTrainedExerciseUseCase;
import com.marmouset.workout.app.trainedexercise.usecase.impl.CreateTrainedExerciseUseCaseImpl;
import com.marmouset.workout.app.trainedexercise.usecase.impl.DeleteTrainedExerciseUseCaseImpl;
import com.marmouset.workout.app.trainedexercise.usecase.impl.ListTrainedExerciseUseCaseImpl;
import com.marmouset.workout.app.trainedexercise.usecase.impl.UpdateTrainedExerciseUseCaseImpl;
import com.marmouset.workout.app.workout.adapter.WorkoutLogController;
import com.marmouset.workout.app.workout.adapter.WorkoutLogRepositoryGateway;
import com.marmouset.workout.app.workout.adapter.impl.WorkoutLogControllerImpl;
import com.marmouset.workout.app.workout.adapter.impl.WorkoutLogRepositoryImpl;
import com.marmouset.workout.app.workout.entity.WorkoutLogFactory;
import com.marmouset.workout.app.workout.external.spring.database.WorkoutLogFactoryImpl;
import com.marmouset.workout.app.workout.usecase.CreateWorkoutLogUseCase;
import com.marmouset.workout.app.workout.usecase.DeleteWorkoutLogUseCase;
import com.marmouset.workout.app.workout.usecase.GetLogDetailsUseCase;
import com.marmouset.workout.app.workout.usecase.ListWorkoutLogsUseCase;
import com.marmouset.workout.app.workout.usecase.UpdateWorkoutLogUseCase;
import com.marmouset.workout.app.workout.usecase.WorkoutLogRepository;
import com.marmouset.workout.app.workout.usecase.impl.CreateWorkoutLogUseCaseImpl;
import com.marmouset.workout.app.workout.usecase.impl.DeleteWorkoutLogUseCaseImpl;
import com.marmouset.workout.app.workout.usecase.impl.GetLogDetailsUseCaseImpl;
import com.marmouset.workout.app.workout.usecase.impl.ListWorkoutLogsUseCaseImpl;
import com.marmouset.workout.app.workout.usecase.impl.UpdateWorkoutLogUseCaseImpl;
import java.util.Objects;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration for the application.
 * This file contains all spring web configuration. It also
 * contains configuration for the dependency injection. Declaring this way
 * allows to have business related classes without any reference to Spring.
 */
@Configuration
public class ApplicationConfiguration
    implements WebMvcConfigurer, ApplicationContextAware {

  private ApplicationContext context;

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOrigins("http://localhost:3000")
        .allowedMethods("GET", "POST", "PATCH", "DELETE")
        .allowedHeaders("*")
        .allowCredentials(true);
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext)
      throws BeansException {
    context = applicationContext;
  }

  /**
   * Creates an ExerciseController.
   *
   * @return an ExerciseController
   */
  @Bean
  public ExerciseController createExerciseController() {
    return new ExerciseControllerImpl(createListExercisesUseCase());
  }

  /**
   * Creates a TrainedExerciseController.
   *
   * @return a TrainedExerciseController
   */
  @Bean
  public TrainedExerciseController createTrainedExerciseController() {
    return new TrainedExerciseControllerImpl(
        createCreateTrainedExerciseUseCase(),
        createDeleteTrainedExerciseUseCase(),
        createListTrainedExercisesUseCase(),
        createUpdateTrainedExerciseUseCase());
  }

  /**
   * Creates a WorkoutLogController.
   *
   * @return a WorkoutLogController
   */
  @Bean
  public WorkoutLogController createWorkoutLogController() {
    return new WorkoutLogControllerImpl(
        createCreateWorkoutLogUseCase(),
        createDeleteWorkoutLogUseCase(),
        createGetLogDetailsUseCase(),
        createListWorkoutLogsUseCase(),
        createUpdateWorkoutLogUseCase());
  }

  /**
   * Creates a ProgressionController.
   *
   * @return a ProgressionController
   */
  @Bean
  public ProgressionController createProgressionController() {
    return new ProgressionControllerImpl(
        createCalcRepsProgChartUc());
  }

  private CalculateRepsProgressionChartUseCase createCalcRepsProgChartUc() {
    return new CalculateRepsProgressionChartUseCaseImpl(
        createExerciseRepository(),
        createTrainedExerciseRepository());
  }

  private UpdateTrainedExerciseUseCase createUpdateTrainedExerciseUseCase() {
    return new UpdateTrainedExerciseUseCaseImpl(
        createTrainedExerciseRepository(),
        createWorkoutLogRepository(),
        createExerciseRepository());
  }

  private ListTrainedExercisesUseCase createListTrainedExercisesUseCase() {
    return new ListTrainedExerciseUseCaseImpl(
        createTrainedExerciseRepository(),
        createWorkoutLogRepository());
  }

  private DeleteTrainedExerciseUseCase createDeleteTrainedExerciseUseCase() {
    return new DeleteTrainedExerciseUseCaseImpl(
        createTrainedExerciseRepository(),
        createWorkoutLogRepository());
  }

  private WorkoutLogRepository createWorkoutLogRepository() {
    validateContextNotNull();
    return new WorkoutLogRepositoryImpl(
        context.getBean(WorkoutLogRepositoryGateway.class),
        createWorkoutLogFactory());
  }

  private WorkoutLogFactory createWorkoutLogFactory() {
    return new WorkoutLogFactoryImpl();
  }

  private UpdateWorkoutLogUseCase createUpdateWorkoutLogUseCase() {
    return new UpdateWorkoutLogUseCaseImpl(createWorkoutLogRepository());
  }

  private ListWorkoutLogsUseCase createListWorkoutLogsUseCase() {
    return new ListWorkoutLogsUseCaseImpl(createWorkoutLogRepository());
  }

  private GetLogDetailsUseCase createGetLogDetailsUseCase() {
    return new GetLogDetailsUseCaseImpl(createWorkoutLogRepository());
  }

  private DeleteWorkoutLogUseCase createDeleteWorkoutLogUseCase() {
    return new DeleteWorkoutLogUseCaseImpl(createWorkoutLogRepository());
  }

  private CreateWorkoutLogUseCase createCreateWorkoutLogUseCase() {
    return new CreateWorkoutLogUseCaseImpl(createWorkoutLogRepository());
  }

  private CreateTrainedExerciseUseCase createCreateTrainedExerciseUseCase() {
    return new CreateTrainedExerciseUseCaseImpl(
        createTrainedExerciseRepository(),
        createWorkoutLogRepository(),
        createExerciseRepository());
  }

  private TrainedExerciseRepository createTrainedExerciseRepository() {
    validateContextNotNull();
    return new TrainedExerciseRepositoryImpl(
        context.getBean(TrainedExerciseRepositoryGateway.class),
        createTrainedExerciseFactory(),
        createExerciseSetFactory());
  }

  private ExerciseSetFactory createExerciseSetFactory() {
    return new ExerciseSetFactoryImpl();
  }

  private TrainedExerciseFactory createTrainedExerciseFactory() {
    return new TrainedExerciseFactoryImpl();
  }

  private ListExercisesUseCase createListExercisesUseCase() {
    return new ListExercisesUseCaseImpl(createExerciseRepository());
  }

  private ExerciseFactory createExerciseFactory() {
    return new ExerciseFactoryImpl();
  }

  private ExerciseRepository createExerciseRepository() {
    validateContextNotNull();
    return new ExerciseRepositoryImpl(
        context.getBean(ExerciseRepositoryGateway.class),
        createExerciseFactory());
  }

  private void validateContextNotNull() {
    Objects.requireNonNull(context, "Context is null");
  }

}
