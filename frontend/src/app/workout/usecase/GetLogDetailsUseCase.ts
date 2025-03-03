import WorkoutLog from '../entity/WorkoutLog';

export default interface GetLogDetailsUseCase {
  getLogDetails(uuid: string): Promise<WorkoutLog>;
}
