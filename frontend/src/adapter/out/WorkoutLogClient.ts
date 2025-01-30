import NewWorkoutLog from '../../app/port/out/dto/NewWorkoutLog';
import WorkoutLogClientPort from '../../app/port/out/WorkoutLogClientPort';
import LogFetchError from '../../domain/log/LogFetchError';
import AbstractClient from './AbstractClient';
import WorkoutLogResponse from './dto/WorkoutLogResponse';

export default class WorkoutLogClient 
  extends AbstractClient implements WorkoutLogClientPort {
    
  protected getPath(): string {
    return '/log';
  }
  
  async listWorkouts(): Promise<WorkoutLogResponse[]> {
    const response = await fetch(this.url);
    if (!response.ok) {
      throw new LogFetchError();
    }

    return response.json();
  }

  async getWorkoutLogDetails(uuid: string): Promise<WorkoutLogResponse> {
    const response = await fetch(`${this.url}/${uuid}`);
    if (!response.ok) {
      throw new LogFetchError();
    }

    return response.json();
  }


  async createWorkoutLog(log: NewWorkoutLog): Promise<WorkoutLogResponse> {
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
