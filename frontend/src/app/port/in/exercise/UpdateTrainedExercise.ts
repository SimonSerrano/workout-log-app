import TrainedExercise from '../../../domain/exercise/TrainedExercise';
import TrainedExerciseFormDTO from '../dto/TrainedExerciseFormDTO';

export default interface UpdateTrainedExercise {
  update(workoutId: string, 
    trainedId: number,
    newTrained: TrainedExerciseFormDTO): Promise<TrainedExercise>
}