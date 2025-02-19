import WorkoutLog from '../../domain/log/WorkoutLog';
import GetLogDetails from '../../port/in/workout/GetLogDetails';
import WorkoutLogResponseMapper 
  from '../../port/out/mapper/WorkoutLogResponseMapper';
import WorkoutLogClient from '../../port/out/WorkoutLogClient';

export default class getLogDetailsUseCase implements GetLogDetails {
  constructor(
    private readonly logClient: WorkoutLogClient,
    private readonly mapper: WorkoutLogResponseMapper
  ) {}

  async getLogDetails(uuid: string): Promise<WorkoutLog> {
    const log = await this.logClient.getWorkout(uuid);
    return this.mapper.toWorkoutLog(log);
  }
}
