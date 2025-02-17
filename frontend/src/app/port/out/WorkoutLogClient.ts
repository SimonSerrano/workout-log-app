import WorkoutLogResponse from '../../../external/web/dto/WorkoutLogResponse';
import NewWorkoutLog from './dto/NewWorkoutLog';

export default interface WorkoutLogClient {
  list(): Promise<WorkoutLogResponse[]>
  getWorkout(uuid: string): Promise<WorkoutLogResponse>
  create(log: NewWorkoutLog): Promise<WorkoutLogResponse>
  delete(uuid: string): Promise<void>
}
