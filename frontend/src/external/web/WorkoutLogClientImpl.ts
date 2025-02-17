import NewWorkoutLog from '../../app/port/out/dto/NewWorkoutLog';
import WorkoutLogClient from '../../app/port/out/WorkoutLogClient';
import LogFetchError from '../../app/domain/log/LogFetchError';
import AbstractClient from './AbstractClient';
import WorkoutLogResponse from './dto/WorkoutLogResponse';

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
}
