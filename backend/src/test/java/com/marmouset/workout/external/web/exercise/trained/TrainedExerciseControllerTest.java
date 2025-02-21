package com.marmouset.workout.external.web.exercise.trained;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marmouset.workout.app.port.in.exercise.CreateTrainedExercise;
import com.marmouset.workout.app.port.in.exercise.CreateTrainedExerciseCommandBuilder;
import com.marmouset.workout.app.port.in.exercise.DeleteTrainedExercise;
import com.marmouset.workout.app.port.in.exercise.ListTrainedExercises;
import com.marmouset.workout.app.port.in.exercise.UpdateTrainedExercise;
import com.marmouset.workout.app.port.in.exercise.UpdatedTrainedExerciseCommandBuilder;
import com.marmouset.workout.app.port.out.exercise.ExerciseResponse;
import com.marmouset.workout.app.port.out.exercise.trained.TrainedExerciseResponseBuilder;
import com.marmouset.workout.app.port.out.set.ExerciseSetResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    var trained1 = new TrainedExerciseResponseBuilder()
        .setId(new Random().nextLong())
        .setLogId(logId).setExercise(new ExerciseResponse("Pull up"))
        .setSets(createSetTriplet(4, 4, 5))
        .build();
    var trained2 = new TrainedExerciseResponseBuilder()
        .setId(new Random().nextLong())
        .setLogId(logId).setExercise(new ExerciseResponse("Push up"))
        .setSets(createSetTriplet(6, 6, 8))
        .build();

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
    var response = new TrainedExerciseResponseBuilder()
        .setId(8L)
        .setLogId(logId)
        .setExercise(new ExerciseResponse("Pull up"))
        .setSets(Collections.emptyList())
        .build();
    when(createTrainedExercise.create(
        new CreateTrainedExerciseCommandBuilder()
            .setLogId(logId)
            .setExerciseId(exerciseId)
            .setSets(Collections.emptyList())
            .build()))
        .thenReturn(response);

    mockMvc.perform(MockMvcRequestBuilders
        .post("/log/" + logId + "/trained")
        .contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(body)))
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
    var body = Map.of("exerciseId", exerciseId, "sets", List.of(8, 8, 6));
    var response = new TrainedExerciseResponseBuilder()
        .setId(8L)
        .setLogId(logId)
        .setExercise(new ExerciseResponse("Pull up"))
        .setSets(Collections.emptyList())
        .build();
    when(updateTrainedExercise.update(
        new UpdatedTrainedExerciseCommandBuilder().setTrainedId(trainedId)
            .setLogId(logId).setExerciseId(exerciseId).setSets(List.of(8, 8, 6))
            .build()))
        .thenReturn(response);

    mockMvc.perform(MockMvcRequestBuilders
        .patch("/log/" + logId + "/trained/" + trainedId)
        .contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(body)))
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

  @Test
  void shouldCreateExerciseWithWeight()
      throws Exception {
    var logId = UUID.randomUUID();
    var exerciseId = "Pull up";
    var weight = 30;
    var body = Map.of(
        "exerciseId", exerciseId,
        "weight", weight);

    var response = new TrainedExerciseResponseBuilder()
        .setId(8L)
        .setLogId(logId)
        .setExercise(new ExerciseResponse("Pull up"))
        .setSets(Collections.emptyList())
        .setWeight(weight)
        .build();
    when(createTrainedExercise.create(
        new CreateTrainedExerciseCommandBuilder()
            .setLogId(logId)
            .setExerciseId(exerciseId)
            .setSets(Collections.emptyList())
            .setWeight(weight)
            .build()))
        .thenReturn(response);

    mockMvc.perform(MockMvcRequestBuilders
        .post("/log/" + logId + "/trained")
        .contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(body)))
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(MockMvcResultMatchers
            .jsonPath("$.weight").value(weight));
  }

  @Test
  void shouldUpdateExerciseWithWeight()
      throws Exception {
    var logId = UUID.randomUUID();
    var exerciseId = "Pull up";
    var weight = 30;
    var trainedId = 8L;
    var body = Map.of(
        "exerciseId", exerciseId,
        "weight", weight);

    var response = new TrainedExerciseResponseBuilder()
        .setId(8L)
        .setLogId(logId)
        .setExercise(new ExerciseResponse("Pull up"))
        .setSets(Collections.emptyList())
        .setWeight(weight)
        .build();
    when(updateTrainedExercise.update(
        new UpdatedTrainedExerciseCommandBuilder()
            .setLogId(logId)
            .setTrainedId(trainedId)
            .setExerciseId(exerciseId)
            .setSets(Collections.emptyList())
            .setWeight(weight)
            .build()))
        .thenReturn(response);

    mockMvc.perform(MockMvcRequestBuilders
        .patch("/log/" + logId + "/trained/" + trainedId)
        .contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(body)))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers
            .jsonPath("$.weight").value(weight));
  }

  private List<ExerciseSetResponse> createSetTriplet(int first, int second,
      int third) {
    return List.of(
        new ExerciseSetResponse(1L, first),
        new ExerciseSetResponse(2L, second),
        new ExerciseSetResponse(3L, third));
  }
}