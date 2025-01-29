import { List, ListItem } from "@mui/material";
import WorkoutLogElement from "./WorkoutLogElement";
import WorkoutLog from "../../../../../domain/log/WorkoutLog";


export interface WorkoutLogListProps {
  logs: WorkoutLog[]
}

export default function WorkoutLogList(props: WorkoutLogListProps) {
  return <List>
  {
    props.logs.map((log) => (
      <ListItem key={log.id}>
        <WorkoutLogElement log={log}/>
      </ListItem>
    ))
  }
</List>
}