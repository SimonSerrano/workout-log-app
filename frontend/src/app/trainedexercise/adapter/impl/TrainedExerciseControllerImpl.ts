import TrainedExerciseFormDTO from 
  '../dto/TrainedExerciseFormDTO';
import TrainedExercise from '../../entity/TrainedExercise';
import CreateTrainedExerciseUseCase 
  from '../../usecase/CreateTrainedExerciseUseCase';
import DeleteTrainedExerciseUseCase 
  from '../../usecase/DeleteTrainedExerciseUseCase';
import ListTrainedExercisesUseCase 
  from '../../usecase/ListTrainedExercisesUseCase';
import UpdateTrainedExerciseUseCase 
  from '../../usecase/UpdateTrainedExerciseUseCase';
import TrainedExerciseController from '../TrainedExerciseController';

export default class TrainedExerciseControllerImpl 
implements TrainedExerciseController {

  constructor(
    private readonly createUseCase: CreateTrainedExerciseUseCase,
    private readonly deleteUseCase: DeleteTrainedExerciseUseCase,
    private readonly listUseCase: ListTrainedExercisesUseCase,
    private readonly updateUseCase: UpdateTrainedExerciseUseCase) {
    
  }

  create(
    workoutId: string, 
    newTrained: TrainedExerciseFormDTO): Promise<TrainedExercise> {
    return this.createUseCase.create(workoutId, newTrained);
  }
  delete(workoutId: string, trainedId: number): Promise<void> {
    return this.deleteUseCase.delete(workoutId, trainedId);
  }
  list(workoutId: string): Promise<TrainedExercise[]> {
    return this.listUseCase.list(workoutId);
  }
  update(
    workoutId: string, 
    trainedId: number, 
    newTrained: TrainedExerciseFormDTO): Promise<TrainedExercise> {
    return this.updateUseCase.update(workoutId, trainedId, newTrained);
  }
}