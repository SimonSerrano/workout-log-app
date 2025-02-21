import TrainedExercise from '../../../domain/exercise/TrainedExercise';
import TrainedExerciseFormDTO from '../dto/TrainedExerciseFormDTO';


export default interface CreateTrainedExercise {
  create(
    workoutId: string, 
    newTrained: TrainedExerciseFormDTO): Promise<TrainedExercise>
}