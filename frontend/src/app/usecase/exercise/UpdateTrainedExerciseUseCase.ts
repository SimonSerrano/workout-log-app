import TrainedExercise from '../../domain/exercise/TrainedExercise';
import TrainedExerciseFormDTO from '../../port/in/dto/TrainedExerciseForm';
import UpdateTrainedExercise from '../../port/in/exercise/UpdateTrainedExercise';
import TrainedExerciseResponseMapper 
  from '../../port/out/mapper/TrainedExerciseResponseMapper';
import TrainedExerciseClient from '../../port/out/TrainedExerciseClient';

export default class UpdateTrainedExerciseUseCase 
implements UpdateTrainedExercise {

  constructor(
    private readonly client: TrainedExerciseClient,
    private readonly mapper: TrainedExerciseResponseMapper
  ) {
    
  }

  async update(
    workoutId: string, 
    trainedId: number,
    newTrained: TrainedExerciseFormDTO): Promise<TrainedExercise> {
    const response = await this.client.update(workoutId, trainedId, newTrained);
    return this.mapper.toTrainedExercise(response);
  }
}