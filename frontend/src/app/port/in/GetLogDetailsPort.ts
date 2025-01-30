import WorkoutLog from '../../../domain/log/WorkoutLog';

export default interface GetLogDetailsPort {
  getLogDetails(uuid: string): Promise<WorkoutLog>;
}
