import WorkoutLog from '../../../../domain/log/WorkoutLog';
import WorkoutLogResponse from '../../../../adapter/out/dto/WorkoutLogResponse';

export default class WorkoutLogResponseMapper {
  toWorkoutLog(response: WorkoutLogResponse): WorkoutLog {
    return {
      id: response.id,
      title: response.title,
      createdAt: new Intl.DateTimeFormat(undefined, {
        dateStyle: 'long',
        timeStyle: 'medium',
      }).format(new Date(response.createdAtTimestamp * 1000)),
    };
  }
}
