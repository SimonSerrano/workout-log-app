import CreateTrainedExerciseUseCase 
  from '../CreateTrainedExerciseUseCase';
import TrainedExerciseFormDTO from 
  '../../adapter/dto/TrainedExerciseFormDTO';
import TrainedExerciseClientGateway 
  from '../../adapter/TrainedExerciseClientGateway';
import TrainedExercise from '../../entity/TrainedExercise';

export default class CreateTrainedExerciseUseCaseImpl 
implements CreateTrainedExerciseUseCase {

  constructor(
    private readonly clientGateway: TrainedExerciseClientGateway) {}


  async create(
    workoutId: string, 
    newTrained: TrainedExerciseFormDTO): Promise<TrainedExercise> {
    return await this.clientGateway.create(workoutId, newTrained);
  }
  
}