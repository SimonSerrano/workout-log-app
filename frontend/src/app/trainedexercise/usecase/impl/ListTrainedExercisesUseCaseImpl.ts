import ListTrainedExercisesUseCase from '../ListTrainedExercisesUseCase';
import TrainedExerciseClientGateway from 
  '../../adapter/TrainedExerciseClientGateway';
import TrainedExercise from '../../entity/TrainedExercise';

export default class ListTrainedExercisesUseCaseImpl 
implements ListTrainedExercisesUseCase {

  constructor(
    private readonly clientGateway: TrainedExerciseClientGateway
  ) {}

  async list(workoutId: string): Promise<TrainedExercise[]> {
    return await this.clientGateway.list(workoutId);    
  }
}