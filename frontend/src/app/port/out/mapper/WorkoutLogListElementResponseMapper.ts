import WorkoutLog from "../../../../domain/log/WorkoutLog";
import WorkoutLogListElementResponse from "../../../../adapter/out/dto/WorkoutLogListElementResponse";

export default class WorkoutLogListElementResponseMapper {

  toWorkoutLog(response: WorkoutLogListElementResponse): WorkoutLog {
    return {
      id: response.id,
      title: response.title,
      createdAt: new Intl.DateTimeFormat(undefined, { dateStyle: 'long', timeStyle: 'medium' }).format(new Date(response.createdAtTimestamp * 1000))
    }
  }
}