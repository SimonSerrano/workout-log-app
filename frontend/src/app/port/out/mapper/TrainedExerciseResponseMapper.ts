import TrainedExerciseResponse 
  from '../../../../external/web/dto/TrainedExerciseResponse';
import TrainedExercise from '../../../domain/exercise/TrainedExercise';


export default class TrainedExerciseResponseMapper {
  toTrainedExercise(response: TrainedExerciseResponse): TrainedExercise {
    return {
      id: response.id,
      exercise: response.exercise,
      logId: response.logId,
      sets: response.sets,
      weight: response.weight,
    };
  }
}
