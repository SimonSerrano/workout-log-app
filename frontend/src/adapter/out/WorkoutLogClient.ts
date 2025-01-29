import WorkoutLogClientPort from "../../app/port/out/WorkoutLogClientPort";
import LogFetchError from "../../domain/log/LogFetchError";
import WorkoutLogListElementResponse from "./dto/WorkoutLogListElementResponse";

export default class WorkoutLogClient implements WorkoutLogClientPort {

  constructor(private url = "http://localhost:8080/log") {}

  async listWorkouts(): Promise<WorkoutLogListElementResponse[]> {
    const response = await fetch(this.url);
      if(!response.ok) {
        throw new LogFetchError();
      }
  
      return response.json();
  }

}