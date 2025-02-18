package com.marmouset.workout.external.web.exercise.trained;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marmouset.workout.app.port.in.exercise.CreateTrainedExercise;
import com.marmouset.workout.app.port.in.exercise.CreateTrainedExerciseCommand;
import com.marmouset.workout.app.port.in.exercise.DeleteTrainedExercise;
import com.marmouset.workout.app.port.in.exercise.ListTrainedExercises;
import com.marmouset.workout.app.port.in.exercise.UpdateTrainedExercise;
import com.marmouset.workout.app.port.in.exercise.UpdatedTrainedExerciseCommand;
import com.marmouset.workout.app.port.out.exercise.ExerciseResponse;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponse;
import com.marmouset.workout.app.port.out.set.ExerciseSetResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
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
  @MockitoBean
  private UpdateTrainedExercise updateTrainedExercise;

  @Test
  void shouldReturnListOfTrainedExercises() throws Exception {
    var logId = UUID.randomUUID();

    var trained1 = new TrainedExerciseResponse(
        new Random().nextLong(),
        logId,
        new ExerciseResponse("Pull up"),
        createSetTriplet(4, 4, 5));
    var trained2 = new TrainedExerciseResponse(
        new Random().nextLong(),
        logId,
        new ExerciseResponse("Push up"),
        createSetTriplet(6, 6, 8));


    when(listTrainedExercises.list(logId)).thenReturn(
        List.of(trained1, trained2));

    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/log/" + logId + "/trained"))
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
    var trainedId = 9L;
    mockMvc
        .perform(MockMvcRequestBuilders.delete(
            "/log/" + logId + "/trained/" + trainedId))
        .andExpect(MockMvcResultMatchers.status().isNoContent());
    verify(deleteTrainedExercise, times(1))
        .delete(logId, trainedId);
  }

  @Test
  void shouldCreateTrainedExercise() throws Exception {
    var logId = UUID.randomUUID();
    var exerciseId = "Pull up";
    var body = new HashMap<>();
    body.put("exerciseId", exerciseId);
    var response = new TrainedExerciseResponse(8L, logId,
        new ExerciseResponse("Pull up"),
        Collections.emptyList());
    when(createTrainedExercise.create(
        new CreateTrainedExerciseCommand(logId, exerciseId,
            Collections.emptyList())))
        .thenReturn(response);

    mockMvc.perform(MockMvcRequestBuilders
            .post("/log/" + logId + "/trained")
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(body))
        )
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(MockMvcResultMatchers
            .jsonPath("$.logId").value(logId.toString()))
        .andExpect(MockMvcResultMatchers
            .jsonPath("$.id").value(response.id()))
        .andExpect(MockMvcResultMatchers
            .jsonPath("$.exercise.name")
            .value(response.exercise().name()))
        .andExpect(MockMvcResultMatchers
            .jsonPath("$.sets.length()").value(response.sets().size()));
  }

  @Test
  void shouldReturnBadRequestWhenLogIdIsInvalidOnGet() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders
            .get("/log/toto/trained"))
        .andExpect(MockMvcResultMatchers
            .status().isBadRequest());

  }

  @Test
  void shouldReturnBadRequestWhenLogIsInvalidOnDelete() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders
            .delete("/log/toto/trained/8"))
        .andExpect(MockMvcResultMatchers
            .status().isBadRequest());
  }

  @Test
  void shouldReturnBadRequestWhenTrainedIdIsInvalidOnDelete() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders
            .delete("/log/" + UUID.randomUUID() + "/trained/toto"))
        .andExpect(MockMvcResultMatchers
            .status().isBadRequest());
  }


  @Test
  void shouldUpdateAndExerciseAndReturnOk()
      throws Exception {
    var logId = UUID.randomUUID();
    var exerciseId = "Pull up";
    var trainedId = 8L;
    var body = new HashMap<>();
    body.put("exerciseId", exerciseId);
    var response = new TrainedExerciseResponse(8L, logId,
        new ExerciseResponse("Pull up"),
        Collections.emptyList());
    when(updateTrainedExercise.update(
        new UpdatedTrainedExerciseCommand(trainedId, logId, exerciseId)))
        .thenReturn(response);

    mockMvc.perform(MockMvcRequestBuilders
            .patch("/log/" + logId + "/trained/" + trainedId)
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(body))
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers
            .jsonPath("$.logId").value(logId.toString()))
        .andExpect(MockMvcResultMatchers
            .jsonPath("$.id").value(response.id()))
        .andExpect(MockMvcResultMatchers
            .jsonPath("$.exercise.name")
            .value(response.exercise().name()))
        .andExpect(MockMvcResultMatchers
            .jsonPath("$.sets.length()").value(response.sets().size()));
  }

  private List<ExerciseSetResponse> createSetTriplet(int first, int second,
                                                     int third) {
    return List.of(
        new ExerciseSetResponse(1L, first),
        new ExerciseSetResponse(2L, second),
        new ExerciseSetResponse(3L, third));
  }
}