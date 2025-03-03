import NewTrainedExercise from './dto/NewTrainedExercise';
import TrainedExercise from '../entity/TrainedExercise';

export default interface TrainedExerciseClientGateway {
  list(workoutId: string): Promise<TrainedExercise[]>
  create(
    workoutId: string, 
    newTrained: NewTrainedExercise): Promise<TrainedExercise>
  update(
    workoutId: string,
    trainedId: number,
    trained: NewTrainedExercise
  ): Promise<TrainedExercise>
  delete(
    workoutId: string,
    trainedId: number
  ): Promise<void>
}