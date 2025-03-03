import { createContext, useContext } from 'react';
import TrainedExerciseController 
  from '../../../adapter/TrainedExerciseController';
import TrainedExercise from '../../../entity/TrainedExercise';



export const TrainedExerciseControllerContext = 
createContext<TrainedExerciseController>({
  create: async (): Promise<TrainedExercise> => {
    return {exercise: { name: '',}, id: -1, logId: '', sets: [],};
  },
  delete: async (): Promise<void> => {
    return ;
  },
  list: async (): Promise<TrainedExercise[]> => {
    return [];
  },
  update: async (): Promise<TrainedExercise> => {
    return {exercise: { name: '',}, id: -1, logId: '', sets: [],};
  },
});

export function useTrainedExerciseController() {
  return useContext(TrainedExerciseControllerContext);
}
