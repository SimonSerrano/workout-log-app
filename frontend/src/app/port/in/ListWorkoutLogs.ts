import WorkoutLog from '../../domain/log/WorkoutLog';

export default interface ListWorkoutLogs {
  list(): Promise<WorkoutLog[]>;
}
