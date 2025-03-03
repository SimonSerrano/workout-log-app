import TrainedExercise from '../../../entity/TrainedExercise';
import NewTrainedExercise from '../../../adapter/dto/NewTrainedExercise';
import TrainedExerciseClientGateway 
  from '../../../adapter/TrainedExerciseClientGateway';
import TrainedExerciseClient from '../TrainedExerciseClient';
import TrainedExerciseResponseMapper 
  from '../mapper/TrainedExerciseResponseMapper';

export default class TrainedExerciseClientGatewayImpl 
implements TrainedExerciseClientGateway {

  private readonly mapper: TrainedExerciseResponseMapper;


  constructor(
    private readonly client: TrainedExerciseClient) {
    this.mapper = new TrainedExerciseResponseMapper();
  }

  list(workoutId: string): Promise<TrainedExercise[]> {
    return this.client.list(workoutId);
  }
  async create(
    workoutId: string, 
    newTrained: NewTrainedExercise): Promise<TrainedExercise> {
    const response = await this.client.create(workoutId, newTrained);
    return this.mapper.toTrainedExercise(response);
  }
  async update(
    workoutId: string, 
    trainedId: number, 
    trained: NewTrainedExercise): Promise<TrainedExercise> {
    const response = await this.client.update(workoutId, trainedId, trained);
    return this.mapper.toTrainedExercise(response);
  }
  delete(
    workoutId: string, 
    trainedId: number): Promise<void> {
    return this.client.delete(workoutId, trainedId);
  }
  
}