package com.marmouset.workout.external.web.exercise;


import static org.mockito.Mockito.when;

import com.marmouset.workout.app.port.in.exercise.ListExercises;
import com.marmouset.workout.app.port.out.exercise.ExerciseResponse;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ExerciseController.class)
class ExerciseControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private ListExercises listExercises;

  @Test
  void shouldReturnExercisesList() throws Exception {
    var ex1 = new ExerciseResponse("Pull up");
    var ex2 = new ExerciseResponse("Push up");
    when(listExercises.list()).thenReturn(List.of(
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