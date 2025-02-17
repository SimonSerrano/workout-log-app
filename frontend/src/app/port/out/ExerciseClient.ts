import Exercise from '../../domain/exercise/Exercise';

export default interface ExerciseClient {
  list(): Promise<Exercise[]>
}