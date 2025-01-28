package com.marmouset.workout.adapter.in;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marmouset.workout.adapter.in.dto.CreateWorkoutLogCommand;
import com.marmouset.workout.adapter.in.dto.CreateWorkoutLogRequest;
import com.marmouset.workout.adapter.in.mapper.WorkoutLogRequestMapper;
import com.marmouset.workout.adapter.out.dto.WorkoutLogListElementResponse;
import com.marmouset.workout.app.port.in.CreateWorkoutLogPort;
import com.marmouset.workout.app.port.in.DeleteWorkoutLogPort;
import com.marmouset.workout.app.port.in.GetLogDetailsPort;
import com.marmouset.workout.app.port.in.ListWorkoutLogsPort;
import com.marmouset.workout.domain.WorkoutLog;
import com.marmouset.workout.domain.WorkoutLogNotFound;

@WebMvcTest(WorkoutLogController.class)
@ContextConfiguration(classes = { WorkoutLogController.class, WorkoutLogRequestMapper.class })
public class WorkoutLogControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private ListWorkoutLogsPort listWorkoutLogsPort;

  @MockitoBean
  private GetLogDetailsPort getLogDetailsPort;

  @MockitoBean
  private CreateWorkoutLogPort createWorkoutLogPort;

  @MockitoBean
  private DeleteWorkoutLogPort deleteWorkoutLogPort;

  @Test
  void shouldReturnLogsFromService() throws Exception {
    List<WorkoutLogListElementResponse> returnedLogs = Arrays.asList(
        new WorkoutLogListElementResponse(UUID.randomUUID(), "Toto", 1738071414L),
        new WorkoutLogListElementResponse(UUID.randomUUID(), "Titi", 1738071414L));
    when(listWorkoutLogsPort.listWorkouts()).thenReturn(returnedLogs);

    mockMvc.perform(get("/log"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()").value(2))
        .andExpect(jsonPath("$[0].title").value("Toto"))
        .andExpect(jsonPath("$[1].title").value("Titi"));
  }

  @Test
  void shouldReturnLogFromService() throws Exception {
    WorkoutLog returnedLog = new WorkoutLog("Toto");
    UUID uuid = UUID.randomUUID();
    when(getLogDetailsPort.getDetails(uuid)).thenReturn(returnedLog);

    mockMvc.perform(get("/log/" + uuid.toString()))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.title").value("Toto"));
  }

  @Test
  void shouldReturnNotFoundResponse() throws Exception {
    UUID uuid = UUID.randomUUID();
    when(getLogDetailsPort.getDetails(uuid)).thenThrow(new WorkoutLogNotFound(uuid));

    mockMvc.perform(get("/log/" + uuid.toString()))
        .andExpect(status().isNotFound());
  }

  @Test
  void shouldCreateANewWorkoutLog() throws Exception {
    var command = new CreateWorkoutLogCommand("Toto");
    var log = new WorkoutLog("Toto");
    when(createWorkoutLogPort.createWorkoutLog(command)).thenReturn(log);
    var request = new CreateWorkoutLogRequest();
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
    mockMvc.perform(delete("/log/" + uuid.toString())).andExpect(status().isNoContent());
  }
}
