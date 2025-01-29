import { PropsWithChildren } from "react";
import { ListWorkoutLogsContext } from "./ListWorkoutLogsContext";
import ListWorkoutLogsUseCase from "../../../../app/usecase/ListWorkoutLogsUseCase";
import WorkoutLogClient from "../../../out/WorkoutLogClient";
import WorkoutLogListElementResponseMapper from "../../../../app/port/out/mapper/WorkoutLogListElementResponseMapper";




export default function ListWorkoutLogsProvider(props: PropsWithChildren) {

  const useCase = new ListWorkoutLogsUseCase(new WorkoutLogClient(), new WorkoutLogListElementResponseMapper());

  return <ListWorkoutLogsContext.Provider value={useCase}>{props.children}</ListWorkoutLogsContext.Provider>
}


