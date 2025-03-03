import ExerciseSet from '../set/ExerciseSet';
import Exercise from '../../exercise/entity/Exercise';

export default interface TrainedExercise {
  id: number
  sets: ExerciseSet[]
  logId: string
  exercise: Exercise
  weight?: number
}