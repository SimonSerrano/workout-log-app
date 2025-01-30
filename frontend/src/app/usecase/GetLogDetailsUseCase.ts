import WorkoutLog from '../../domain/log/WorkoutLog';
import getLogDetailsPort from '../port/in/GetLogDetailsPort';
import WorkoutLogResponseMapper 
  from '../port/out/mapper/WorkoutLogResponseMapper';
import WorkoutLogClientPort from '../port/out/WorkoutLogClientPort';

export default class getLogDetailsUseCase implements getLogDetailsPort {
  constructor(
    private readonly logClient: WorkoutLogClientPort,
    private readonly mapper: WorkoutLogResponseMapper
  ) {}

  async getLogDetails(uuid: string): Promise<WorkoutLog> {
    const log = await this.logClient.getWorkoutLogDetails(uuid);
    return this.mapper.toWorkoutLog(log);
  }
}
