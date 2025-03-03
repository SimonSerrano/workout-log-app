import TrainedExercise from '../entity/TrainedExercise';

export default interface ListTrainedExercisesUseCase {
  list(workoutId: string): Promise<TrainedExercise[]>
}