import WorkoutLog from '../../domain/log/WorkoutLog';
import ListWorkoutLogs from '../../port/in/workout/ListWorkoutLogs';
import WorkoutLogResponseMapper 
  from '../../port/out/mapper/WorkoutLogResponseMapper';
import WorkoutLogClient from '../../port/out/WorkoutLogClient';

export default class ListWorkoutLogsUseCase implements ListWorkoutLogs {
  constructor(
    private readonly logClient: WorkoutLogClient,
    private readonly mapper: WorkoutLogResponseMapper
  ) {}

  async list(): Promise<WorkoutLog[]> {
    const workouts = await this.logClient.list();
    return workouts.map(this.mapper.toWorkoutLog.bind(this.mapper));
  }
}
