package com.marmouset.workout.app.exercise.external.spring.web;


import static org.mockito.Mockito.when;

import com.marmouset.workout.ApplicationConfiguration;
import com.marmouset.workout.app.exercise.adapter.ExerciseController;
import com.marmouset.workout.app.exercise.adapter.dto.ExerciseResponse;
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

@WebMvcTest(value = {ExerciseSpringController.class},
    excludeFilters = @ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE,
        classes = {ApplicationConfiguration.class}))
class ExerciseSpringControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private ExerciseController controller;

  @Test
  void shouldReturnExercisesList() throws Exception {
    var ex1 = new ExerciseResponse("Pull up");
    var ex2 = new ExerciseResponse("Push up");
    when(controller.list()).thenReturn(List.of(
        ex1,
        ex2
    ));

    mockMvc.perform(MockMvcRequestBuilders.get("/exercise"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers
            .jsonPath("$.length()").value(2))
        .andExpect(
            MockMvcResultMatchers
                .jsonPath("$[0].name").value(ex1.name()))
        .andExpect(
            MockMvcResultMatchers
                .jsonPath("$[1].name").value(ex2.name()));
  }
}