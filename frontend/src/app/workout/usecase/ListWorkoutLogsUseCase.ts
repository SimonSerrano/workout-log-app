import WorkoutLog from '../entity/WorkoutLog';

export default interface ListWorkoutLogsUseCase {
  list(): Promise<WorkoutLog[]>;
}
