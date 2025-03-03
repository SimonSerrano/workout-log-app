import NewWorkoutLogForm from '../dto/NewWorkoutLogForm';
import CreateWorkoutLogUseCaseImpl 
  from '../../usecase/impl/CreateWorkoutLogUseCaseImpl';
import DeleteWorkoutLogUseCaseImpl 
  from '../../usecase/impl/DeleteWorkoutLogUseCaseImpl';
import GetLogDetailsUseCaseImpl 
  from '../../usecase/impl/GetLogDetailsUseCaseImpl';
import ListWorkoutLogsUseCaseImpl 
  from '../../usecase/impl/ListWorkoutLogsUseCaseImpl';
import WorkoutLog from '../../entity/WorkoutLog';
import WorkoutController from '../WorkoutController';

export default class WorkoutControllerImpl implements WorkoutController {

  constructor(
    private readonly createUseCase: CreateWorkoutLogUseCaseImpl,
    private readonly deleteUseCase: DeleteWorkoutLogUseCaseImpl,
    private readonly getUseCase: GetLogDetailsUseCaseImpl,
    private readonly listUseCase: ListWorkoutLogsUseCaseImpl
  ) {
    
  }


  create(newLog: NewWorkoutLogForm): Promise<WorkoutLog> {
    return this.createUseCase.create(newLog);
  }
  delete(workoutId: string): Promise<void> {
    return this.deleteUseCase.delete(workoutId);
  }
  getLogDetails(uuid: string): Promise<WorkoutLog> {
    return this.getUseCase.getLogDetails(uuid);
  }
  list(): Promise<WorkoutLog[]> {
    return this.listUseCase.list();
  }
}