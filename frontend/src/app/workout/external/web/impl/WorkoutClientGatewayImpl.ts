import NewWorkoutLog from '../../../adapter/dto/NewWorkoutLog';
import WorkoutLogResponseMapper 
  from '../mapper/WorkoutLogResponseMapper';
import WorkoutLogClient from '../WorkoutLogClient';
import WorkoutClientGateway from '../../../adapter/WorkoutClientGateway';
import WorkoutLog from '../../../entity/WorkoutLog';

export default class WorkoutClientGatewayImpl implements WorkoutClientGateway {

  private readonly mapper: WorkoutLogResponseMapper;

  constructor(
    private readonly client: WorkoutLogClient
  ) {
    this.mapper = new WorkoutLogResponseMapper();
  }

  async list(): Promise<WorkoutLog[]> {
    const response = await this.client.list();
    return response.map(res => this.mapper.toWorkoutLog(res));
  }
  async getWorkout(uuid: string): Promise<WorkoutLog> {
    const response = await this.client.getWorkout(uuid);
    return this.mapper.toWorkoutLog(response);
  }
  async create(log: NewWorkoutLog): Promise<WorkoutLog> {
    const response = await this.client.create(log);
    return this.mapper.toWorkoutLog(response);
  }
  delete(uuid: string): Promise<void> {
    return this.client.delete(uuid);
  }
  
}