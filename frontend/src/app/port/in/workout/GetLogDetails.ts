import WorkoutLog from '../../../domain/log/WorkoutLog';

export default interface GetLogDetails {
  getLogDetails(uuid: string): Promise<WorkoutLog>;
}
