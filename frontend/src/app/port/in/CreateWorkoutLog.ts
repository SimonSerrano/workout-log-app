import WorkoutLog from '../../domain/log/WorkoutLog';
import NewWorkoutLogForm from '../../../external/ui/dto/NewWorkoutLogForm';

export default interface CreateWorkoutLog {
  create(newLog: NewWorkoutLogForm): Promise<WorkoutLog>
}