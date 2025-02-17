import { createContext, useContext } from 'react';
import WorkoutLog from '../../../app/domain/log/WorkoutLog';
import GetLogDetailsPort from '../../../app/port/in/GetLogDetailsPort';

export const GetLogDetailsContext = createContext<GetLogDetailsPort>({
  getLogDetails: async (): Promise<WorkoutLog> => {
    return { id: '', name: '', createdAt: '', };
  },
});

export function useGetLogDetails() {
  return useContext(GetLogDetailsContext);
}
