import { createContext, useContext } from 'react';
import WorkoutLog from '../../../../app/domain/log/WorkoutLog';
import ListWorkoutLogs from '../../../../app/port/in/ListWorkoutLogs';

export const ListWorkoutLogsContext = createContext<ListWorkoutLogs>({
  list: async (): Promise<WorkoutLog[]> => {
    return [];
  },
});

export function useListWorkoutLogs() {
  return useContext(ListWorkoutLogsContext);
}
