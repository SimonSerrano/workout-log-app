import ExerciseResponse from '../../../exercise/adapter/dto/ExerciseResponse';


export default interface RepsProgressionChartResponse {
  exercise: ExerciseResponse
  chart: RepsDataPointResponse[]
}



export interface RepsDataPointResponse {
  timestamp: number
  reps: number
}