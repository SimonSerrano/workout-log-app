import Exercise from '../../domain/exercise/Exercise';

export default interface ListExercises {
  list(): Promise<Exercise[]>
}