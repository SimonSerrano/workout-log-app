import WorkoutLog from '../../entity/WorkoutLog';
import CreateWorkoutLogUseCase from '../CreateWorkoutLogUseCase';
import NewWorkoutLogForm from '../../adapter/dto/NewWorkoutLogForm';
import WorkoutClientGateway from '../../adapter/WorkoutClientGateway';

export default class CreateWorkoutLogUseCaseImpl 
implements CreateWorkoutLogUseCase {
  
  constructor(
    private readonly clientGateway: WorkoutClientGateway 
  ){}
  
  async create(newLog: NewWorkoutLogForm): Promise<WorkoutLog> {
    return this.clientGateway.create(newLog);
  }

}