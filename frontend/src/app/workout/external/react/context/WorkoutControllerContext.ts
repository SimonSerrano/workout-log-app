import { createContext, useContext } from 'react';
import WorkoutController 
  from '../../../adapter/WorkoutController';
import WorkoutLog from '../../../entity/WorkoutLog';

export const WorkoutControllerContext = createContext<WorkoutController>({
  create: async (newLog) => {
    return {id: '', name: newLog.name, createdAt: '',};
  },
  delete: async () => {
    return;
  },
  getLogDetails: async (): Promise<WorkoutLog> => {
    return { id: '', name: '', createdAt: '', };
  },
  list: async (): Promise<WorkoutLog[]> => {
    return [];
  },
});

export function useWorkoutController() {
  return useContext(WorkoutControllerContext);
}
