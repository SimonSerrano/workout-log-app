import { createContext, useContext } from "react";
import WorkoutLog from "../../domain/log/WorkoutLog";
import getLogDetailsPort from "../port/in/GetLogDetailsPort";

export const GetLogDetailsContext = createContext<getLogDetailsPort>(
  {
    getLogDetails: async (): Promise<WorkoutLog> => {
      return {id: "", title: "", createdAt: ""};
    }
  }
);

export function useGetLogDetails() {
  return useContext(GetLogDetailsContext);
}