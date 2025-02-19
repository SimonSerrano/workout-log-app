import { createContext, useContext } from 'react';
import ListTrainedExercises from '../../../../../app/port/in/exercise/ListTrainedExercises';
import TrainedExercise from '../../../../../app/domain/exercise/TrainedExercise';

export const ListTrainedExercisesContext = createContext<ListTrainedExercises>({
  list: async (): Promise<TrainedExercise[]> => {
    return [];
  },
});

export function useListTrainedExercises() {
  return useContext(ListTrainedExercisesContext);
}
