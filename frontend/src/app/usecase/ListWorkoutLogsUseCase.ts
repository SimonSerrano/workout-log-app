import WorkoutLog from '../../domain/log/WorkoutLog';
import ListWorkoutLogsPort from '../port/in/ListWorkoutLogsPort';
import WorkoutLogResponseMapper from '../port/out/mapper/WorkoutLogResponseMapper';
import WorkoutLogClientPort from '../port/out/WorkoutLogClientPort';

export default class ListWorkoutLogsUseCase implements ListWorkoutLogsPort {
  constructor(
    private readonly logClient: WorkoutLogClientPort,
    private readonly mapper: WorkoutLogResponseMapper,
  ) {}

  async listWorkouts(): Promise<WorkoutLog[]> {
    const workouts = await this.logClient.listWorkouts();
    return workouts.map(this.mapper.toWorkoutLog.bind(this.mapper));
  }
}
