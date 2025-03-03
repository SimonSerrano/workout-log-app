import NewWorkoutLog from '../../../adapter/dto/NewWorkoutLog';
import WorkoutLogClient from '../WorkoutLogClient';
import LogFetchError from '../../../adapter/error/LogFetchError';
import AbstractClient from '../../../../shared/external/web/AbstractClient';
import WorkoutLogResponse from '../../../adapter/dto/WorkoutLogResponse';

export default class WorkoutLogClientImpl 
  extends AbstractClient implements WorkoutLogClient {
 
    
  protected getPath(): string {
    return '/log';
  }
  
  async list(): Promise<WorkoutLogResponse[]> {
    const response = await fetch(this.url);
    if (!response.ok) {
      throw new LogFetchError();
    }

    return response.json();
  }

  async getWorkout(uuid: string): Promise<WorkoutLogResponse> {
    const response = await fetch(`${this.url}/${uuid}`);
    if (!response.ok) {
      throw new LogFetchError();
    }

    return response.json();
  }


  async create(log: NewWorkoutLog): Promise<WorkoutLogResponse> {
    const response = await fetch(this.url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(log),
    });

    if(response.status !== 201) {
      throw new LogFetchError();
    }

    return response.json();
  }

  async delete(uuid: string): Promise<void> {
    const response = await fetch(`${this.url}/${uuid}`, {
      method: 'DELETE',
    });

    if(response.status !== 204) {
      throw new LogFetchError();
    }
  }
}
