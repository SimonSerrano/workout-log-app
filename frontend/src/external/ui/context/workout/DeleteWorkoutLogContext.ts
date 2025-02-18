import { createContext, useContext } from 'react';
import DeleteWorkoutLog from '../../../../app/port/in/DeleteWorkoutLog';

export const DeleteWorkoutLogContext = createContext<DeleteWorkoutLog>({
  delete: async () => {
    return;
  },
});

export function useDeleteWorkoutLog() {
  return useContext(DeleteWorkoutLogContext);
}
