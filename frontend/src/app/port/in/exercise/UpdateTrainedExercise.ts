import TrainedExercise from '../../../domain/exercise/TrainedExercise';
import TrainedExerciseFormDTO from '../dto/TrainedExerciseForm';

export default interface UpdateTrainedExercise {
  update(workoutId: string, 
    trainedId: number,
    newTrained: TrainedExerciseFormDTO): Promise<TrainedExercise>
}