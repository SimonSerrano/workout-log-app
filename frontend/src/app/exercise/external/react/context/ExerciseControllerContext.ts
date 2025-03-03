import { createContext, useContext } from 'react';
import ExerciseController from '../../../adapter/ExerciseController';
import Exercise from '../../../entity/Exercise';

export const ExerciseControllerContext = 
createContext<ExerciseController>({
  list: async (): Promise<Exercise[]> => {
    return [];
  },
});

export function useExerciseController() {
  return useContext(ExerciseControllerContext);
}
