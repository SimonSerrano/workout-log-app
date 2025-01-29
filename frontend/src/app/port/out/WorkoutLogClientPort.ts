import WorkoutLogResponse from "../../../adapter/out/dto/WorkoutLogResponse";

export default interface WorkoutLogClientPort {
  listWorkouts(): Promise<WorkoutLogResponse[]>;
  getWorkoutLogDetails(uuid: string): Promise<WorkoutLogResponse>
}