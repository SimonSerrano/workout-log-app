import { PropsWithChildren } from "react";
import { ListWorkoutLogsContext } from "./ListWorkoutLogsContext";
import ListWorkoutLogsUseCase from "../usecase/ListWorkoutLogsUseCase";
import WorkoutLogClient from "../../adapter/out/WorkoutLogClient";
import WorkoutLogResponseMapper from "../port/out/mapper/WorkoutLogResponseMapper";




export default function ListWorkoutLogsProvider(props: PropsWithChildren) {

  const useCase = new ListWorkoutLogsUseCase(new WorkoutLogClient(), new WorkoutLogResponseMapper());

  return <ListWorkoutLogsContext.Provider value={useCase}>{props.children}</ListWorkoutLogsContext.Provider>
}


