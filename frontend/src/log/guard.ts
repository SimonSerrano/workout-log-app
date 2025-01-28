import WorkoutLog from "../generated/com/marmouset/workout/app/log/WorkoutLog";

export function isRequiredLog(log: WorkoutLog): log is Required<WorkoutLog> {
  return Boolean(log.title !== undefined
    && log.id !== undefined
    && log.createdAt !== undefined
    && log.updatedAt !== undefined
    && log.version !== undefined
  );
}