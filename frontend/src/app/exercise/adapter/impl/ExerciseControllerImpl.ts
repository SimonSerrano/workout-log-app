import Exercise from '../../entity/Exercise';
import ListExercisesUseCase from '../../usecase/ListExercisesUseCase';
import ExerciseController from '../ExerciseController';

export default class ExerciseControllerImpl implements ExerciseController {

  constructor(private readonly listUseCase: ListExercisesUseCase) {}


  list(): Promise<Exercise[]> {
    return this.listUseCase.list();
  }
  
}