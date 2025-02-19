import { createContext, useContext } from 'react';
import WorkoutLog from '../../../../app/domain/log/WorkoutLog';
import GetLogDetails from '../../../../app/port/in/workout/GetLogDetails';

export const GetLogDetailsContext = createContext<GetLogDetails>({
  getLogDetails: async (): Promise<WorkoutLog> => {
    return { id: '', name: '', createdAt: '', };
  },
});

export function useGetLogDetails() {
  return useContext(GetLogDetailsContext);
}
