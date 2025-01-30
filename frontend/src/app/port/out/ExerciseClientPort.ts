import Exercise from '../../../domain/exercise/Exercise';

export default interface ExerciseClientPort {
  getExercises(): Promise<Exercise[]>
}