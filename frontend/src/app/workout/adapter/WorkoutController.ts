import WorkoutLog from '../entity/WorkoutLog';
import NewWorkoutLogForm from './dto/NewWorkoutLogForm';

export default interface WorkoutController {
  create(newLog: NewWorkoutLogForm): Promise<WorkoutLog>
  delete(workoutId: string): Promise<void>
  getLogDetails(uuid: string): Promise<WorkoutLog>;
  list(): Promise<WorkoutLog[]>;
}