import TrainedExercise from '../../domain/exercise/TrainedExercise';

export default interface ListTrainedExercises {
  list(workoutId: string): Promise<TrainedExercise[]>
}