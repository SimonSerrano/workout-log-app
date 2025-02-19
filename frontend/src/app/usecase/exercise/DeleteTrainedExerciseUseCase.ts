import DeleteTrainedExercise 
  from '../../port/in/exercise/DeleteTrainedExercise';
import TrainedExerciseClient from '../../port/out/TrainedExerciseClient';

export default class DeleteTrainedExerciseUseCase 
implements DeleteTrainedExercise {
  
  constructor(
    private readonly client: TrainedExerciseClient
  ) {
    
  }
  
  delete(workoutId: string, trainedId: number): Promise<void> {
    return this.client.delete(workoutId, trainedId);
  }
  
}