import WorkoutLog from '../../../domain/log/WorkoutLog';
import WorkoutLogResponse from 
  '../../../../external/web/dto/WorkoutLogResponse';

export default class WorkoutLogResponseMapper {
  toWorkoutLog(response: WorkoutLogResponse): WorkoutLog {
    return {
      id: response.id,
      name: response.name,
      createdAt: new Intl.DateTimeFormat(undefined, {
        dateStyle: 'long',
        timeStyle: 'medium',
      }).format(new Date(response.createdAtTimestamp * 1000)),
    };
  }
}
