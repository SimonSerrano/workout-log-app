import ExerciseClientPort from '../../app/port/out/ExerciseClientPort';
import Exercise from '../../app/domain/exercise/Exercise';
import AbstractClient from './AbstractClient';

export default class ExerciseClient 
  extends AbstractClient 
  implements ExerciseClientPort {

  protected getPath(): string {
    return '/exercise';
  }

  async getExercises(): Promise<Exercise[]> {
    const response = await fetch(this.url);
    if(!response.ok) {
      throw new Error('Cannot load exercises');
    }

    return response.json();
  }
}