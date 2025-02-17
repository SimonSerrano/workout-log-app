import { createContext, useContext } from 'react';
import CreateWorkoutLogPort from '../port/in/CreateWorkoutLogPort';

export const CreateWorkoutLogContext = createContext<CreateWorkoutLogPort>({
  createNewWorkoutLog: async (newLog) => {
    return {id: '', name: newLog.title, createdAt: '',};
  },
});

export function useCreateWorkoutLog() {
  return useContext(CreateWorkoutLogContext);
}
