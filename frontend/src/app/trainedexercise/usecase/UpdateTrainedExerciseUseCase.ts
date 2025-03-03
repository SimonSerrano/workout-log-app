import TrainedExerciseFormDTO from '../adapter/dto/TrainedExerciseFormDTO';
import TrainedExercise from '../entity/TrainedExercise';

export default interface UpdateTrainedExerciseUseCase {
  update(workoutId: string, 
    trainedId: number,
    newTrained: TrainedExerciseFormDTO): Promise<TrainedExercise>
}