import WorkoutLog from '../../../domain/log/WorkoutLog';
import NewWorkoutLogForm from '../../../adapter/in/dto/NewWorkoutLogForm';

export default interface CreateWorkoutLogPort {
  createNewWorkoutLog(newLog: NewWorkoutLogForm): Promise<WorkoutLog>
}