import WorkoutLog from '../../domain/log/WorkoutLog';
import NewWorkoutLogForm from '../../../external/ui/dto/NewWorkoutLogForm';

export default interface CreateWorkoutLogPort {
  createNewWorkoutLog(newLog: NewWorkoutLogForm): Promise<WorkoutLog>
}