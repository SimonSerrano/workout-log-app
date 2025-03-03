import NewTrainedExercise from '../../../adapter/dto/NewTrainedExercise';
import AbstractClient from '../../../../shared/external/web/AbstractClient';
import TrainedExerciseResponse 
  from '../../../../../external/web/dto/TrainedExerciseResponse';
import TrainedExerciseClient from '../TrainedExerciseClient';

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

  async update(
    workoutId: string, 
    trainedId: number, 
    trained: NewTrainedExercise): 
    Promise<TrainedExerciseResponse> {
    const response = await fetch(
      `${this.url}/${workoutId}/trained/${trainedId}`, 
      {
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


  async delete(workoutId: string, trainedId: number): Promise<void> {
    const response = await fetch(
      `${this.url}/${workoutId}/trained/${trainedId}`, {
        method: 'DELETE',
      });
    
    if(response.status !== 204) {
      throw new Error('Cannot delete trained exercise');
    }
  }

}