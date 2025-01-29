import WorkoutLog from "./WorkoutLog";

export function isRequiredLog(log: WorkoutLog): log is Required<WorkoutLog> {
  return Boolean(log.title !== undefined
    && log.id !== undefined
    && log.createdAt !== undefined
  );
}