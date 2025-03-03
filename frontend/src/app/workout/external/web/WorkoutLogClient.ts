import WorkoutLogResponse from '../../adapter/dto/WorkoutLogResponse';
import NewWorkoutLog from '../../adapter/dto/NewWorkoutLog';

export default interface WorkoutLogClient {
  list(): Promise<WorkoutLogResponse[]>
  getWorkout(uuid: string): Promise<WorkoutLogResponse>
  create(log: NewWorkoutLog): Promise<WorkoutLogResponse>
  delete(uuid: string): Promise<void>
}
