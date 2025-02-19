import { createContext, useContext } from 'react';
import CreateWorkoutLog 
  from '../../../../app/port/in/workout/CreateWorkoutLog';

export const CreateWorkoutLogContext = createContext<CreateWorkoutLog>({
  create: async (newLog) => {
    return {id: '', name: newLog.name, createdAt: '',};
  },
});

export function useCreateWorkoutLog() {
  return useContext(CreateWorkoutLogContext);
}
