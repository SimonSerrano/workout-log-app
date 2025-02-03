package com.marmouset.workout.external.web.workout;

import jakarta.validation.constraints.NotBlank;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
final class CreateOrUpdateWorkoutLogBody {
  private @NotBlank(message = "Name is mandatory") String name;

  public CreateOrUpdateWorkoutLogBody() {
  }

  public String getName() {
    return name;
  }

  public CreateOrUpdateWorkoutLogBody setName(String name) {
    this.name = name;
    return this;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || obj.getClass() != this.getClass()) {
      return false;
    }
    var that = (CreateOrUpdateWorkoutLogBody) obj;
    return Objects.equals(this.name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "CreateOrUpdateWorkoutLogBody[name=" + name + ']';
  }


}
