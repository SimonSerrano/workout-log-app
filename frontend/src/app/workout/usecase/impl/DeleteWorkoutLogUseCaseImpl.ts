import DeleteWorkoutLogUseCase from '../DeleteWorkoutLogUseCase';
import WorkoutClientGateway from '../../adapter/WorkoutClientGateway';

export default class DeleteWorkoutLogUseCaseImpl 
implements DeleteWorkoutLogUseCase {
  
  constructor(
    private readonly clientGateway: WorkoutClientGateway 
  ){}
  
  delete(workoutId: string): Promise<void> {
    return this.clientGateway.delete(workoutId);
  }
  
}