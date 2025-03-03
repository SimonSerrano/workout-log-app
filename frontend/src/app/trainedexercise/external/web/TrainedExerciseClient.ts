import NewTrainedExercise from '../../adapter/dto/NewTrainedExercise';
import TrainedExerciseResponse from '../../adapter/dto/TrainedExerciseResponse';



export default interface TrainedExerciseClient {
  list(workoutId: string): Promise<TrainedExerciseResponse[]>
  create(
    workoutId: string, 
    newTrained: NewTrainedExercise): Promise<TrainedExerciseResponse>
  update(
    workoutId: string,
    trainedId: number,
    trained: NewTrainedExercise
  ): Promise<TrainedExerciseResponse>
  delete(
    workoutId: string,
    trainedId: number
  ): Promise<void>
}