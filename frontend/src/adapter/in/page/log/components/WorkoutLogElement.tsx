import { Button, Card, CardActions, CardContent, Typography } from "@mui/material";
import { useNavigate } from "@tanstack/react-router";
import { isRequiredLog } from "../../../../../domain/log/guard";
import LogWithEmptyValueError from "../../../../../domain/log/LogWithEmptyValueError";
import WorkoutLog from "../../../../../domain/log/WorkoutLog";

interface WorkoutLogElementProps {
  log: WorkoutLog
}

export default function WorkoutLogElement({log}: WorkoutLogElementProps ) {

  const navigate = useNavigate();

  if(!isRequiredLog(log)) {
    throw new LogWithEmptyValueError();
  }
  return <Card>
    <CardContent>
      <Typography variant="h5">{log.title}</Typography>
      <Typography>{log.createdAt}</Typography>
    </CardContent>
    <CardActions>
      <Button onClick={() => navigate({ to: `/log/${log.id}` })}>Details</Button>
    </CardActions>
  </Card>
}