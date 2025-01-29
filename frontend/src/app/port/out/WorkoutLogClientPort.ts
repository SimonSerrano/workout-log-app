import WorkoutLogListElementResponse from "../../../adapter/out/dto/WorkoutLogListElementResponse";

export default interface WorkoutLogClientPort {
  listWorkouts(): Promise<WorkoutLogListElementResponse[]>;
}