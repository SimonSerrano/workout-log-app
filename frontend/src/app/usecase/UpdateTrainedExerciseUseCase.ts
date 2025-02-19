import TrainedExercise from '../domain/exercise/TrainedExercise';
import NewTrainedExerciseForm from '../port/in/dto/NewTrainedExerciseForm';
import UpdateTrainedExercise from '../port/in/UpdateTrainedExercise';
import TrainedExerciseResponseMapper 
  from '../port/out/mapper/TrainedExerciseResponseMapper';
import TrainedExerciseClient from '../port/out/TrainedExerciseClient';

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
    newTrained: NewTrainedExerciseForm): Promise<TrainedExercise> {
    const response = await this.client.update(workoutId, trainedId, newTrained);
    return this.mapper.toTrainedExercise(response);
  }
}