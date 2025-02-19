import TrainedExercise from '../../domain/exercise/TrainedExercise';
import ListTrainedExercises from '../../port/in/exercise/ListTrainedExercises';
import TrainedExerciseResponseMapper 
  from '../../port/out/mapper/TrainedExerciseResponseMapper';
import TrainedExerciseClient from '../../port/out/TrainedExerciseClient';

export default class ListTrainedExercisesUseCase 
implements ListTrainedExercises {

  constructor(
    private readonly client: TrainedExerciseClient,
    private readonly mapper: TrainedExerciseResponseMapper
  ) {}

  async list(workoutId: string): Promise<TrainedExercise[]> {
    const responses = await this.client.list(workoutId);    
    return responses.map((res) => this.mapper.toTrainedExercise(res));
  }
}