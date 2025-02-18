import { createContext, useContext } from 'react';
import ListExercises from '../../../app/port/in/ListExercises';
import Exercise from '../../../app/domain/exercise/Exercise';

export const ListExercisesContext = 
createContext<ListExercises>({
  list: async (): Promise<Exercise[]> => {
    return [];
  },
});

export function useListExercises() {
  return useContext(ListExercisesContext);
}
