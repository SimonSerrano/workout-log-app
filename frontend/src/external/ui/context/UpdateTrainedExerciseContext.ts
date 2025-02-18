import { createContext, useContext } from 'react';
import TrainedExercise from '../../../app/domain/exercise/TrainedExercise';
import UpdateTrainedExercise from '../../../app/port/in/UpdateTrainedExercise';



export const UpdateTrainedExerciseContext = 
createContext<UpdateTrainedExercise>({
  update: async (): Promise<TrainedExercise> => {
    return {exercise: { name: '',}, id: -1, logId: '', sets: [],};
  },
});

export function useUpdateTrainedExercise() {
  return useContext(UpdateTrainedExerciseContext);
}
