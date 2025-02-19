import Exercise from '../../domain/exercise/Exercise';
import ListExercises from '../../port/in/exercise/ListExercises';
import ExerciseClient from '../../port/out/ExerciseClient';
import ExerciseReponseMapper from '../../port/out/mapper/ExerciseResponseMapper';

export default class ListExercisesUseCase implements ListExercises {

  constructor(
    private readonly client: ExerciseClient,
    private readonly mapper: ExerciseReponseMapper
  ) {
    
  }


  async list(): Promise<Exercise[]> {
    const response = await this.client.list();
    return response.map((res) => this.mapper.toExercise(res));
  }
  
}