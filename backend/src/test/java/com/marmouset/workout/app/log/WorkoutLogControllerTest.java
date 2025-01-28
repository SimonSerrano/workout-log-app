package com.marmouset.workout.app.log;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(WorkoutLogController.class)
public class WorkoutLogControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private WorkoutLogService service;

  @Test
  void shouldReturnLogsFromService() throws Exception {
    List<WorkoutLog> returnedLogs = Arrays.asList(new WorkoutLog("Toto"), new WorkoutLog("Titi"));
    when(service.getLogs()).thenReturn(returnedLogs);

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
    when(service.getLog(uuid)).thenReturn(returnedLog);

    mockMvc.perform(get("/log/" + uuid.toString()))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.title").value("Toto"));
  }

  @Test
  void shouldReturnNotFoundResponse() throws Exception {
    UUID uuid = UUID.randomUUID();
    when(service.getLog(uuid)).thenThrow(new WorkoutLogNotFound(uuid));

    mockMvc.perform(get("/log/" + uuid.toString()))
        .andExpect(status().isNotFound());
  }

}
