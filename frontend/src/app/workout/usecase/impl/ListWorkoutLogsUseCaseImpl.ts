import WorkoutLog from '../../entity/WorkoutLog';
import ListWorkoutLogsUseCase from '../ListWorkoutLogsUseCase';
import WorkoutClientGateway from '../../adapter/WorkoutClientGateway';

export default class ListWorkoutLogsUseCaseImpl 
implements ListWorkoutLogsUseCase {
  constructor(
    private readonly clientGateway: WorkoutClientGateway
  ) {}

  async list(): Promise<WorkoutLog[]> {
    return this.clientGateway.list();
  }
}
