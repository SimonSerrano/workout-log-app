import Exercise from '../entity/Exercise';

export default interface ListExercisesUseCase {
  list(): Promise<Exercise[]>
}