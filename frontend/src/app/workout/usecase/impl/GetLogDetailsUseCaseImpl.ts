import WorkoutLog from '../../entity/WorkoutLog';
import GetLogDetailsUseCase from '../GetLogDetailsUseCase';
import WorkoutClientGateway from '../../adapter/WorkoutClientGateway';

export default class GetLogDetailsUseCaseImpl implements GetLogDetailsUseCase {
  constructor(
    private readonly clientGateway: WorkoutClientGateway
  ) {}

  async getLogDetails(uuid: string): Promise<WorkoutLog> {
    return this.clientGateway.getWorkout(uuid);
  }
}
