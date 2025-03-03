import TrainedExerciseFormDTO from '../adapter/dto/TrainedExerciseFormDTO';
import TrainedExercise from '../entity/TrainedExercise';


export default interface CreateTrainedExerciseUseCase {
  create(
    workoutId: string, 
    newTrained: TrainedExerciseFormDTO): Promise<TrainedExercise>
}