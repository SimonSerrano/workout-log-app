import ListExercisesUseCase from '../ListExercisesUseCase';
import ExerciseClientGateway from '../../adapter/ExerciseClientGateway';
import Exercise from '../../entity/Exercise';

export default class ListExercisesUseCaseImpl implements ListExercisesUseCase {

  constructor(
    private readonly clientGateway: ExerciseClientGateway
  ) {
    
  }


  async list(): Promise<Exercise[]> {
    return this.clientGateway.list();
  }
  
}