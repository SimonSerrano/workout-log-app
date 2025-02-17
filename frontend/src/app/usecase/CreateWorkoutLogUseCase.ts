import WorkoutLog from '../domain/log/WorkoutLog';
import CreateWorkoutLogPort from '../port/in/CreateWorkoutLogPort';
import NewWorkoutLogForm from '../../external/ui/dto/NewWorkoutLogForm';
import WorkoutLogResponseMapper 
  from '../port/out/mapper/WorkoutLogResponseMapper';
import WorkoutLogClientPort from '../port/out/WorkoutLogClientPort';

export default class CreateWorkoutLogUseCase implements CreateWorkoutLogPort {
  
  constructor(
    private readonly client: WorkoutLogClientPort, 
    private readonly mapper: WorkoutLogResponseMapper
  ){}
  
  async createNewWorkoutLog(newLog: NewWorkoutLogForm): Promise<WorkoutLog> {
    const response = await this.client.createWorkoutLog(newLog);
    return this.mapper.toWorkoutLog(response);
  }

}