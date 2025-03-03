import WorkoutLog from '../entity/WorkoutLog';
import NewWorkoutLogForm from '../adapter/dto/NewWorkoutLogForm';

export default interface CreateWorkoutLogUseCase {
  create(newLog: NewWorkoutLogForm): Promise<WorkoutLog>
}