import WorkoutLogClientPort from "../../app/port/out/WorkoutLogClientPort";
import LogFetchError from "../../domain/log/LogFetchError";
import WorkoutLogResponse from "./dto/WorkoutLogResponse";

export default class WorkoutLogClient implements WorkoutLogClientPort {

  constructor(private url = "http://localhost:8080/log") {}
  

  async listWorkouts(): Promise<WorkoutLogResponse[]> {
    const response = await fetch(this.url);
      if(!response.ok) {
        throw new LogFetchError();
      }
  
      return response.json();
  }

  async getWorkoutLogDetails(uuid: string): Promise<WorkoutLogResponse> {
    const response = await fetch(`${this.url}/${uuid}`);
      if(!response.ok) {
        throw new LogFetchError();
      }
  
      return response.json();
  }

}