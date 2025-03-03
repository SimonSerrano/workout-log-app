import NewWorkoutLog from './dto/NewWorkoutLog';
import WorkoutLog from '../entity/WorkoutLog';

export default interface WorkoutClientGateway {
  list(): Promise<WorkoutLog[]>
  getWorkout(uuid: string): Promise<WorkoutLog>
  create(log: NewWorkoutLog): Promise<WorkoutLog>
  delete(uuid: string): Promise<void>
}