import WorkoutLog from "../../domain/log/WorkoutLog";
import ListWorkoutLogsPort from "../port/in/ListWorkoutLogsPort";
import WorkoutLogListElementResponseMapper from "../port/out/mapper/WorkoutLogListElementResponseMapper";
import WorkoutLogClientPort from "../port/out/WorkoutLogClientPort";


export default class ListWorkoutLogsUseCase implements ListWorkoutLogsPort {

  constructor(private logClient: WorkoutLogClientPort, private mapper: WorkoutLogListElementResponseMapper){}

  async listWorkouts(): Promise<WorkoutLog[]> {
    const workouts = await this.logClient.listWorkouts(); 
    return workouts.map(this.mapper.toWorkoutLog.bind(this.mapper));
  }

}