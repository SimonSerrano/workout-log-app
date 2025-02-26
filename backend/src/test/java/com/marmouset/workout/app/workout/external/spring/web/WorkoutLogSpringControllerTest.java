package com.marmouset.workout.app.workout.external.spring.web;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marmouset.workout.ApplicationConfiguration;
import com.marmouset.workout.app.workout.adapter.WorkoutLogController;
import com.marmouset.workout.app.workout.adapter.dto.WorkoutLogResponse;
import com.marmouset.workout.app.workout.entity.WorkoutLogNotFoundException;
import com.marmouset.workout.app.workout.usecase.dto.CreateWorkoutLogCommand;
import com.marmouset.workout.app.workout.usecase.dto.UpdateWorkoutLogCommand;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(value = {
    WorkoutLogSpringController.class},
    excludeFilters = @ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE,
        classes = {ApplicationConfiguration.class}))
class WorkoutLogSpringControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private WorkoutLogController controller;


  @Test
  void shouldReturnLogs() throws Exception {
    List<WorkoutLogResponse> returnedLogs = Arrays.asList(
        new WorkoutLogResponse(UUID.randomUUID(), "Toto", 1738071414L),
        new WorkoutLogResponse(UUID.randomUUID(), "Titi", 1738071414L));
    when(controller.list()).thenReturn(returnedLogs);

    mockMvc.perform(get("/log"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()").value(2))
        .andExpect(jsonPath("$[0].name").value("Toto"))
        .andExpect(jsonPath("$[1].name").value("Titi"));
  }

  @Test
  void shouldReturnLogDetails() throws Exception {
    WorkoutLogResponse returnedLog =
        new WorkoutLogResponse(UUID.randomUUID(), "Toto", 1738071414L);
    UUID uuid = UUID.randomUUID();
    when(controller.get(uuid)).thenReturn(returnedLog);

    mockMvc.perform(get("/log/" + uuid))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("Toto"));
  }

  @Test
  void shouldReturnNotFoundResponseWhenGettingDetailsOfAnUnknownWorkout()
      throws Exception {
    UUID uuid = UUID.randomUUID();
    when(controller.get(uuid)).thenThrow(
        new WorkoutLogNotFoundException(uuid));

    mockMvc.perform(get("/log/" + uuid))
        .andExpect(status().isNotFound());
  }

  @Test
  void shouldCreateNewWorkoutLog() throws Exception {
    var command = new CreateWorkoutLogCommand("Toto");
    var log = new WorkoutLogResponse(UUID.randomUUID(), "Toto", 1738071414L);
    when(controller.create(command)).thenReturn(log);
    var body = new CreateOrUpdateWorkoutLogBody().setName("Toto");


    mockMvc
        .perform(
            post("/log")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(body)))
        .andDo(print())
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id").value(log.id().toString()))
        .andExpect(jsonPath("$.name").value(log.name()))
        .andExpect(
            jsonPath("$.createdAtTimestamp").value(log.createdAtTimestamp()));
  }

  @Test
  void shouldDeleteWorkoutLog() throws Exception {
    UUID uuid = UUID.randomUUID();
    mockMvc.perform(delete("/log/" + uuid))
        .andExpect(status().isNoContent());
    verify(controller, times(1)).delete(uuid);
  }

  @Test
  void shouldUpdateWorkoutLogName() throws Exception {

    var body = new CreateOrUpdateWorkoutLogBody().setName("New name");
    UUID uuid = UUID.randomUUID();
    var log =
        new WorkoutLogResponse(uuid, body.getName(), 1738071414L);


    when(controller.update(
        new UpdateWorkoutLogCommand(log.id(), body.getName()))).thenReturn(log);


    mockMvc.perform(patch("/log/" + log.id())
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(body))
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(log.id().toString()))
        .andExpect(jsonPath("$.name").value(log.name()))
        .andExpect(
            jsonPath("$.createdAtTimestamp").value(log.createdAtTimestamp()));
  }
}
