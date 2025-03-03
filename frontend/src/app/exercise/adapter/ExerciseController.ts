import Exercise from '../entity/Exercise';

export default interface ExerciseController {
  list(): Promise<Exercise[]>
}