import ExerciseResponse 
  from '../../../exercise/adapter/dto/ExerciseResponse';
import ExerciseSetResponse 
  from '../../../exerciseset/adapter/dto/ExerciseSetResponse';

export default interface TrainedExerciseResponse {
  id: number
  sets: ExerciseSetResponse[]
  logId: string
  exercise: ExerciseResponse
  weight?: number
}