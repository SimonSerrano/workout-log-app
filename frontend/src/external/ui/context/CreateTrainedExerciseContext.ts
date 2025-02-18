import { createContext, useContext } from 'react';
import CreateTrainedExercise from '../../../app/port/in/CreateTrainedExercise';
import TrainedExercise from '../../../app/domain/exercise/TrainedExercise';



export const CreateTrainedExerciseContext = 
createContext<CreateTrainedExercise>({
  create: async (): Promise<TrainedExercise> => {
    return {exercise: { name: '',}, id: -1, logId: '', sets: [],};
  },
});

export function useCreateTrainedExercise() {
  return useContext(CreateTrainedExerciseContext);
}
