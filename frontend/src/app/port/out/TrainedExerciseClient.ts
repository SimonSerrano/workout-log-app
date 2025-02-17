import TrainedExerciseResponse 
  from '../../../external/web/dto/TrainedExerciseResponse';


export default interface TrainedExerciseClient {
  list(workoutId: string): Promise<TrainedExerciseResponse[]>;
}