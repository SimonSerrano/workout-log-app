import { createContext, useContext } from "react";
import WorkoutLog from "../../../../domain/log/WorkoutLog";
import ListWorkoutLogsPort from "../../../../app/port/in/ListWorkoutLogsPort";

export const ListWorkoutLogsContext = createContext<ListWorkoutLogsPort>(
  {
    listWorkouts: async (): Promise<WorkoutLog[]> => {
      return [];
    }
  }
);

export function useListWorkoutLogs() {
  return useContext(ListWorkoutLogsContext);
}