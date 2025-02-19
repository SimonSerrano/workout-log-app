import DeleteWorkoutLog from '../../port/in/workout/DeleteWorkoutLog';
import WorkoutLogClient from '../../port/out/WorkoutLogClient';

export default class DeleteWorkoutLogUseCase implements DeleteWorkoutLog {
  
  constructor(
    private readonly client: WorkoutLogClient 
  ){}
  
  delete(workoutId: string): Promise<void> {
    return this.client.delete(workoutId);
  }
  
}