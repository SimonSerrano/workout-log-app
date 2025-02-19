import WorkoutLog from '../../domain/log/WorkoutLog';
import CreateWorkoutLog from '../../port/in/workout/CreateWorkoutLog';
import NewWorkoutLogForm from '../../port/in/dto/NewWorkoutLogForm';
import WorkoutLogResponseMapper 
  from '../../port/out/mapper/WorkoutLogResponseMapper';
import WorkoutLogClient from '../../port/out/WorkoutLogClient';

export default class CreateWorkoutLogUseCase implements CreateWorkoutLog {
  
  constructor(
    private readonly client: WorkoutLogClient, 
    private readonly mapper: WorkoutLogResponseMapper
  ){}
  
  async create(newLog: NewWorkoutLogForm): Promise<WorkoutLog> {
    const response = await this.client.create(newLog);
    return this.mapper.toWorkoutLog(response);
  }

}