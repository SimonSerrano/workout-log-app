import Exercise from '../exercise/Exercise';

export default interface RepsProgressionChart {
  exercise: Exercise
  chart: RepsDataPoint[]
}


export interface RepsDataPoint {
  date: Date
  reps: number
}