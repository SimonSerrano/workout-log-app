import TrainedExercise from '../../domain/exercise/TrainedExercise';
import CreateTrainedExercise 
  from '../../port/in/exercise/CreateTrainedExercise';
import TrainedExerciseFormDTO from '../../port/in/dto/TrainedExerciseForm';
import TrainedExerciseResponseMapper 
  from '../../port/out/mapper/TrainedExerciseResponseMapper';
import TrainedExerciseClient from '../../port/out/TrainedExerciseClient';

export default class CreateTrainedExerciseUseCase 
implements CreateTrainedExercise {

  constructor(
    private readonly client: TrainedExerciseClient,
    private readonly mapper: TrainedExerciseResponseMapper) {}


  async create(
    workoutId: string, 
    newTrained: TrainedExerciseFormDTO): Promise<TrainedExercise> {
    const response = await this.client.create(workoutId, newTrained);
    return this.mapper.toTrainedExercise(response);
  }
  
}