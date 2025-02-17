import ExerciseClient from '../../app/port/out/ExerciseClient';
import Exercise from '../../app/domain/exercise/Exercise';
import AbstractClient from './AbstractClient';

export default class ExerciseClientImpl 
  extends AbstractClient 
  implements ExerciseClient {

  protected getPath(): string {
    return '/exercise';
  }

  async list(): Promise<Exercise[]> {
    const response = await fetch(this.url);
    if(!response.ok) {
      throw new Error('Cannot load exercises');
    }

    return response.json();
  }
}