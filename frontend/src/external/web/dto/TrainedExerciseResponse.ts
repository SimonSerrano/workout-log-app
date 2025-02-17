import ExerciseResponse from './ExerciseResponse';
import ExerciseSetResponse from './ExerciseSetResponse';

export default interface TrainedExerciseResponse {
  id: number,
  sets: ExerciseSetResponse[],
  logId: string,
  exercise: ExerciseResponse
}