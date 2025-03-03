import ExerciseResponse from '../../adapter/dto/ExerciseResponse';

export default interface ExerciseClient {
  list(): Promise<ExerciseResponse[]>
}