import WorkoutLogResponse from '../../../adapter/out/dto/WorkoutLogResponse';
import NewWorkoutLog from './dto/NewWorkoutLog';

export default interface WorkoutLogClientPort {
  listWorkouts(): Promise<WorkoutLogResponse[]>
  getWorkoutLogDetails(uuid: string): Promise<WorkoutLogResponse>
  createWorkoutLog(log: NewWorkoutLog): Promise<WorkoutLogResponse>
}
