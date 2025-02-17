import TrainedExerciseClient from '../../app/port/out/TrainedExerciseClient';
import AbstractClient from './AbstractClient';
import TrainedExerciseResponse from './dto/TrainedExerciseResponse';

export default class TrainedExerciseClientImpl 
  extends AbstractClient implements TrainedExerciseClient {
  protected getPath(): string {
    return '/log';
  }
  async list(workoutId: string): Promise<TrainedExerciseResponse[]> {
    const response = await fetch(`${this.url}/${workoutId}/trained`);
    if(!response.ok) {
      throw new Error('Cannot load trained exercises');
    }

    return response.json();
  }

}