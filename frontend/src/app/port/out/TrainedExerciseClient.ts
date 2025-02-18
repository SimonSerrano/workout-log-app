import TrainedExerciseResponse 
  from '../../../external/web/dto/TrainedExerciseResponse';
import NewTrainedExercise from './dto/NewTrainedExercise';


export default interface TrainedExerciseClient {
  list(workoutId: string): Promise<TrainedExerciseResponse[]>
  create(
    workoutId: string, 
    newTrained: NewTrainedExercise): Promise<TrainedExerciseResponse>
  update(
    workoutId: string,
    trained: NewTrainedExercise
  ): Promise<TrainedExerciseResponse>
}