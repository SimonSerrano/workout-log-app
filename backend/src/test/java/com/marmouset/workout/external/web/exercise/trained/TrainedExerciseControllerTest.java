package com.marmouset.workout.external.web.exercise.trained;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.marmouset.workout.app.port.in.exercise.CreateTrainedExercise;
import com.marmouset.workout.app.port.in.exercise.DeleteTrainedExercise;
import com.marmouset.workout.app.port.in.exercise.ListTrainedExercises;
import com.marmouset.workout.app.port.out.exercise.ExerciseResponse;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponse;
import com.marmouset.workout.app.port.out.set.ExerciseSetResponse;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(TrainedExerciseController.class)
class TrainedExerciseControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private ListTrainedExercises listTrainedExercises;
  @MockitoBean
  private CreateTrainedExercise createTrainedExercise;
  @MockitoBean
  private DeleteTrainedExercise deleteTrainedExercise;

  @Test
  void shouldReturnListOfTrainedExercises() throws Exception {
    var trained1 = new TrainedExerciseResponse(UUID.randomUUID(),
        new ExerciseResponse(UUID.randomUUID(), "Pull up"),
        createSetTriplet(4, 4, 5));
    var trained2 = new TrainedExerciseResponse(UUID.randomUUID(),
        new ExerciseResponse(UUID.randomUUID(), "Push up"),
        createSetTriplet(6, 6, 8));

    var logId = UUID.randomUUID();

    when(listTrainedExercises.list(logId)).thenReturn(
        List.of(trained1, trained2));

    mockMvc
        .perform(MockMvcRequestBuilders.get("/log/" + logId + "/trained"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers
            .jsonPath("$.length()").value(2))
        .andExpect(MockMvcResultMatchers
            .jsonPath("$[0].exercise.name")
            .value(trained1.exercise().name()))
        .andExpect(MockMvcResultMatchers
            .jsonPath("$[0].sets[0].reps")
            .value(trained1.sets().get(0).reps()))
        .andExpect(MockMvcResultMatchers
            .jsonPath("$[1].exercise.name")
            .value(trained2.exercise().name()))
        .andExpect(MockMvcResultMatchers
            .jsonPath("$[1].sets[0].reps")
            .value(trained2.sets().get(0).reps()));
  }


  @Test
  void shouldDeleteTrainedExercise() throws Exception {
    var logId = UUID.randomUUID();
    var trainedId = UUID.randomUUID();

    mockMvc
        .perform(MockMvcRequestBuilders.delete(
            "/log/" + logId + "/trained/" + trainedId))
        .andExpect(MockMvcResultMatchers.status().isNoContent());
    verify(deleteTrainedExercise, times(1)).delete(trainedId);
  }

  private List<ExerciseSetResponse> createSetTriplet(int first, int second,
                                                     int third) {
    return List.of(
        new ExerciseSetResponse(UUID.randomUUID(), first),
        new ExerciseSetResponse(UUID.randomUUID(), second),
        new ExerciseSetResponse(UUID.randomUUID(), third));
  }
}