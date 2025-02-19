import TrainedExercise from '../../../domain/exercise/TrainedExercise';
import TrainedExerciseFormDTO from '../dto/TrainedExerciseForm';


export default interface CreateTrainedExercise {
  create(
    workoutId: string, 
    newTrained: TrainedExerciseFormDTO): Promise<TrainedExercise>
}