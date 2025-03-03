import TrainedExerciseFormDTO from 
  '../../adapter/dto/TrainedExerciseFormDTO';
import UpdateTrainedExerciseUseCase from '../UpdateTrainedExerciseUseCase';
import TrainedExerciseClientGateway from 
  '../../adapter/TrainedExerciseClientGateway';
import TrainedExercise from '../../entity/TrainedExercise';

export default class UpdateTrainedExerciseUseCaseImpl 
implements UpdateTrainedExerciseUseCase {

  constructor(
    private readonly clientGateway: TrainedExerciseClientGateway
  ) {
    
  }

  async update(
    workoutId: string, 
    trainedId: number,
    newTrained: TrainedExerciseFormDTO): Promise<TrainedExercise> {
    return await this.clientGateway.update(workoutId, trainedId, newTrained);
  }
}