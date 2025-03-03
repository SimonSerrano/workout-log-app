import DeleteTrainedExerciseUseCase 
  from '../DeleteTrainedExerciseUseCase';
import TrainedExerciseClientGateway from 
  '../../adapter/TrainedExerciseClientGateway';

export default class DeleteTrainedExerciseUseCaseImpl 
implements DeleteTrainedExerciseUseCase {
  
  constructor(
    private readonly clientGateway: TrainedExerciseClientGateway
  ) {
    
  }
  
  delete(workoutId: string, trainedId: number): Promise<void> {
    return this.clientGateway.delete(workoutId, trainedId);
  }
  
}