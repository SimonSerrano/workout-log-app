import { Button, Card, CardActions, CardContent, Typography } from "@mui/material";
import { isRequiredLog } from "../../../../../domain/log/guard";
import LogWithEmptyValueError from "../../../../../domain/log/LogWithEmptyValueError";
import WorkoutLog from "../../../../../domain/log/WorkoutLog";

interface WorkoutLogElementProps {
  log: WorkoutLog
  onDetailsClick(): void
}

export default function WorkoutLogElement({log, onDetailsClick}: WorkoutLogElementProps ) {


  if(!isRequiredLog(log)) {
    throw new LogWithEmptyValueError();
  }
  return <Card>
    <CardContent>
      <Typography variant="h5">{log.title}</Typography>
      <Typography>{log.createdAt}</Typography>
    </CardContent>
    <CardActions>
      <Button onClick={onDetailsClick}>Details</Button>
    </CardActions>
  </Card>
}