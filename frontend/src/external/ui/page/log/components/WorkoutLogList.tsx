import { List, ListItem } from '@mui/material';
import WorkoutLog from '../../../../../app/domain/log/WorkoutLog';

export interface WorkoutLogListProps {
  logs: WorkoutLog[];
  listElementComponent(log: WorkoutLog): JSX.Element;
}

export default function WorkoutLogList(props: WorkoutLogListProps) {
  return (
    <List>
      {props.logs.map((log) => (
        <ListItem key={log.id}>{props.listElementComponent(log)}</ListItem>
      ))}
    </List>
  );
}
