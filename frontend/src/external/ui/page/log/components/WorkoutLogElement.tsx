import {
  Button,
  Card,
  CardActions,
  CardContent,
  Typography
} from '@mui/material';
import { isWorkoutLog } from '../../../../../app/domain/log/guard';
import LogWithEmptyValueError 
  from '../../../../../app/domain/log/LogWithEmptyValueError';
import WorkoutLog from '../../../../../app/domain/log/WorkoutLog';

export interface WorkoutLogElementProps {
  log: WorkoutLog;
  onDetailsClick(log: WorkoutLog): void;
}

export default function WorkoutLogElement({
  log,
  onDetailsClick,
}: WorkoutLogElementProps) {
  if (!isWorkoutLog(log)) {
    throw new LogWithEmptyValueError();
  }
  return (
    <Card>
      <CardContent>
        <Typography variant="h5">{log.name}</Typography>
        <Typography>{log.createdAt}</Typography>
      </CardContent>
      <CardActions>
        <Button onClick={() => onDetailsClick(log)}>Details</Button>
      </CardActions>
    </Card>
  );
}
