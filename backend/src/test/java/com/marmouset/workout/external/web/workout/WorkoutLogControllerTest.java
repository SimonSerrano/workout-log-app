package com.marmouset.workout.external.web.workout;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marmouset.workout.app.domain.workout.WorkoutLogNotFoundException;
import com.marmouset.workout.app.port.in.workout.CreateWorkoutLog;
import com.marmouset.workout.app.port.in.workout.CreateWorkoutLogCommand;
import com.marmouset.workout.app.port.in.workout.DeleteWorkoutLog;
import com.marmouset.workout.app.port.in.workout.GetLogDetails;
import com.marmouset.workout.app.port.in.workout.ListWorkoutLogs;
import com.marmouset.workout.app.port.out.workout.WorkoutLogResponse;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(WorkoutLogController.class)
@ContextConfiguration(classes = {WorkoutLogController.class,
    WorkoutLogRequestMapper.class})
class WorkoutLogControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private ListWorkoutLogs listWorkoutLogs;

  @MockitoBean
  private GetLogDetails getLogDetails;

  @MockitoBean
  private CreateWorkoutLog createWorkoutLog;

  @MockitoBean
  private DeleteWorkoutLog deleteWorkoutLog;

  @Test
  void shouldReturnLogsFromService() throws Exception {
    List<WorkoutLogResponse> returnedLogs = Arrays.asList(
        new WorkoutLogResponse(UUID.randomUUID(), "Toto", 1738071414L),
        new WorkoutLogResponse(UUID.randomUUID(), "Titi", 1738071414L));
    when(listWorkoutLogs.list()).thenReturn(returnedLogs);

    mockMvc.perform(get("/log"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()").value(2))
        .andExpect(jsonPath("$[0].name").value("Toto"))
        .andExpect(jsonPath("$[1].name").value("Titi"));
  }

  @Test
  void shouldReturnLogFromService() throws Exception {
    WorkoutLogResponse returnedLog =
        new WorkoutLogResponse(UUID.randomUUID(), "Toto", 1738071414L);
    UUID uuid = UUID.randomUUID();
    when(getLogDetails.get(uuid)).thenReturn(returnedLog);

    mockMvc.perform(get("/log/" + uuid))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("Toto"));
  }

  @Test
  void shouldReturnNotFoundResponse() throws Exception {
    UUID uuid = UUID.randomUUID();
    when(getLogDetails.get(uuid)).thenThrow(
        new WorkoutLogNotFoundException(uuid));

    mockMvc.perform(get("/log/" + uuid))
        .andExpect(status().isNotFound());
  }

  @Test
  void shouldCreateNewWorkoutLog() throws Exception {
    var command = new CreateWorkoutLogCommand("Toto");
    var log = new WorkoutLogResponse(UUID.randomUUID(), "Toto", 1738071414L);
    when(createWorkoutLog.create(command)).thenReturn(log);
    var request = new CreateWorkoutLogBody();
    request.setTitle("Toto");

    mockMvc
        .perform(
            post("/log")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(request)))
        .andDo(print())
        .andExpect(status().isCreated());
  }

  @Test
  void shouldDeleteWorkoutLog() throws Exception {
    UUID uuid = UUID.randomUUID();
    mockMvc.perform(delete("/log/" + uuid))
        .andExpect(status().isNoContent());
  }
}
