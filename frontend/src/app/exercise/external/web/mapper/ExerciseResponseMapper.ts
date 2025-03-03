import ExerciseResponse from '../../../adapter/dto/ExerciseResponse';
import Exercise from '../../../domain/exercise/Exercise';

export default class ExerciseReponseMapper {
  toExercise(response: ExerciseResponse): Exercise {
    return {
      name: response.name,
    };
  }
}