import ExerciseClientGateway from '../../../adapter/ExerciseClientGateway';
import Exercise from '../../../entity/Exercise';
import ExerciseClient from '../ExerciseClient';
import ExerciseReponseMapper from '../mapper/ExerciseResponseMapper';

export default class ExerciseClientGatewayImpl 
implements ExerciseClientGateway {

  private readonly mapper: ExerciseReponseMapper;

  constructor(private readonly client: ExerciseClient) {
    this.mapper = new ExerciseReponseMapper();
  }


  async list(): Promise<Exercise[]> {
    const response = await this.client.list();
    return response.map((res) => this.mapper.toExercise(res));
  }
  
}