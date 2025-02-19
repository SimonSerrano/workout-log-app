import TrainedExercise from '../../domain/exercise/TrainedExercise';
import NewTrainedExerciseForm from './dto/NewTrainedExerciseForm';

export default interface UpdateTrainedExercise {
  update(workoutId: string, 
    trainedId: number,
    newTrained: NewTrainedExerciseForm): Promise<TrainedExercise>
}