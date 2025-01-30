import WorkoutLog from '../../../domain/log/WorkoutLog';

export default interface ListWorkoutLogsPort {
  listWorkouts(): Promise<WorkoutLog[]>;
}
