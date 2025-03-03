import TrainedExerciseFormDTO from './dto/TrainedExerciseFormDTO';
import TrainedExercise from '../entity/TrainedExercise';

export default interface TrainedExerciseController {
  create(
    workoutId: string, 
    newTrained: TrainedExerciseFormDTO): Promise<TrainedExercise>

  delete(workoutId: string, trainedId: number): Promise<void>
  list(workoutId: string): Promise<TrainedExercise[]>
  update(workoutId: string, 
    trainedId: number,
    newTrained: TrainedExerciseFormDTO): Promise<TrainedExercise>
}