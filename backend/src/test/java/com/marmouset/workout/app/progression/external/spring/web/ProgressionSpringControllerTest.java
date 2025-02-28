package com.marmouset.workout.app.progression.external.spring.web;

import static org.mockito.Mockito.doReturn;

import com.marmouset.workout.ApplicationConfiguration;
import com.marmouset.workout.app.exercise.adapter.dto.ExerciseResponse;
import com.marmouset.workout.app.progression.adapter.ProgressionController;
import com.marmouset.workout.app.progression.adapter.dto.RepsDataPointResponseImpl;
import com.marmouset.workout.app.progression.adapter.dto.RepsProgressionChartResponseImpl;
import com.marmouset.workout.app.progression.usecase.dto.CalculateRepsProgressionChartCommand;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(value = {
    ProgressionSpringController.class }, excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
        ApplicationConfiguration.class }))
public class ProgressionSpringControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private ProgressionController controller;

  @Test
  void shouldReturnChart() throws Exception {
    var response = new RepsProgressionChartResponseImpl(
        new ExerciseResponse("Pull ups"), List.of(
            new RepsDataPointResponseImpl(1000L, 10),
            new RepsDataPointResponseImpl(2000L, 20),
            new RepsDataPointResponseImpl(3000L, 30)));
    doReturn(response).when(controller).calculateRepsProgressionChart(
        new CalculateRepsProgressionChartCommand("Pull ups"));

    mockMvc.perform(
        MockMvcRequestBuilders.get(
            "/exercise/{exerciseId}/progression",
            "Pull ups"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers
            .jsonPath("$.exercise.name")
            .value("Pull ups"))
        .andExpect(MockMvcResultMatchers
            .jsonPath("$.chart.length()")
            .value(3))
        .andExpect(MockMvcResultMatchers
            .jsonPath("$.chart[0].timestamp")
            .value(1000))
        .andExpect(MockMvcResultMatchers
            .jsonPath("$.chart[0].reps")
            .value(10))
        .andExpect(MockMvcResultMatchers
            .jsonPath("$.chart[1].timestamp")
            .value(2000))
        .andExpect(MockMvcResultMatchers
            .jsonPath("$.chart[1].reps")
            .value(20))
        .andExpect(MockMvcResultMatchers
            .jsonPath("$.chart[2].timestamp")
            .value(3000))
        .andExpect(MockMvcResultMatchers
            .jsonPath("$.chart[2].reps")
            .value(30));
  }

  @Test
  void shouldReturnNotFound() {

  }

}
