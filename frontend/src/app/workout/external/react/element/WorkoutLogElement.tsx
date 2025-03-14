import {
  Card,
  CardActionArea,
  CardContent,
  Typography
} from '@mui/material';
import { isWorkoutLog } from '../../../entity/guard';
import LogWithEmptyValueError 
  from '../../../adapter/error/LogWithEmptyValueError';
import WorkoutLog from '../../../entity/WorkoutLog';

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
    <Card sx={{width: '100%',}}>
      <CardActionArea onClick={() => onDetailsClick(log)}>
        <CardContent>
          <Typography variant="h5">{log.name}</Typography>
          <Typography>{log.createdAt}</Typography>
        </CardContent>
      </CardActionArea>
    </Card>
  );
}
