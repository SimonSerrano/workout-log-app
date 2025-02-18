import NewTrainedExercise from '../../app/port/out/dto/NewTrainedExercise';
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

  async create(
    workoutId: string,
    newTrained: NewTrainedExercise): 
    Promise<TrainedExerciseResponse> {
    const response = await fetch(`${this.url}/${workoutId}/trained`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(newTrained),
    });
    
    if(response.status !== 201) {
      throw new Error('Cannot create trained exercise');
    }
    
    return response.json();
  }

  async update(workoutId: string, trained: NewTrainedExercise): 
  Promise<TrainedExerciseResponse> {
    const response = await fetch(`${this.url}/${workoutId}/trained`, {
      method: 'PATCH',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(trained),
    });
    
    if(response.status !== 200) {
      throw new Error('Cannot update trained exercise');
    }
    
    return response.json();
  }

}