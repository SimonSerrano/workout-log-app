import TrainedExercise from '../domain/exercise/TrainedExercise';
import CreateTrainedExercise from '../port/in/CreateTrainedExercise';
import NewTrainedExerciseForm from '../port/in/dto/NewTrainedExerciseForm';
import TrainedExerciseResponseMapper 
  from '../port/out/mapper/TrainedExerciseResponseMapper';
import TrainedExerciseClient from '../port/out/TrainedExerciseClient';

export default class CreateTrainedExerciseUseCase 
implements CreateTrainedExercise {

  constructor(
    private readonly client: TrainedExerciseClient,
    private readonly mapper: TrainedExerciseResponseMapper) {}


  async create(
    workoutId: string, 
    newTrained: NewTrainedExerciseForm): Promise<TrainedExercise> {
    const response = await this.client.create(workoutId, newTrained);
    return this.mapper.toTrainedExercise(response);
  }
  
}