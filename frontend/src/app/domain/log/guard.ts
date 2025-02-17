import WorkoutLog from './WorkoutLog';

export function isWorkoutLog(log: unknown): log is WorkoutLog {
  return (
    typeof log === 'object' &&
    log != null &&
    'name' in log &&
    'id' in log &&
    'createdAt' in log &&
    log.name !== undefined &&
    log.id !== undefined &&
    log.createdAt !== undefined
  );
}
