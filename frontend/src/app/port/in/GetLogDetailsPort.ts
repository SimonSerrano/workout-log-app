import WorkoutLog from '../../../domain/log/WorkoutLog';

export default interface getLogDetailsPort {
  getLogDetails(uuid: string): Promise<WorkoutLog>;
}
