import ExerciseResponse from '../../../external/web/dto/ExerciseResponse';

export default interface ExerciseClient {
  list(): Promise<ExerciseResponse[]>
}