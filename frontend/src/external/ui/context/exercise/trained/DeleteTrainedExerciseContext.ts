import { createContext, useContext } from 'react';
import DeleteTrainedExercise 
  from '../../../../../app/port/in/exercise/DeleteTrainedExercise';

export const DeleteTrainedExerciseContext = 
createContext<DeleteTrainedExercise>({
  delete: async (): Promise<void> => {
    return ;
  },
});

export function useDeleteTrainedExercise() {
  return useContext(DeleteTrainedExerciseContext);
}