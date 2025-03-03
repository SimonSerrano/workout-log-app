import ExerciseClient from '../../app/exercise/external/ExerciseClient';
import AbstractClient from './AbstractClient';
import ExerciseResponse from './dto/ExerciseResponse';

export default class ExerciseClientImpl 
  extends AbstractClient 
  implements ExerciseClient {

  protected getPath(): string {
    return '/exercise';
  }

  async list(): Promise<ExerciseResponse[]> {
    const response = await fetch(this.url);
    if(!response.ok) {
      throw new Error('Cannot load exercises');
    }

    return response.json();
  }
}