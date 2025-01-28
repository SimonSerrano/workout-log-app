import { Button, Card, CardActions, CardContent, Typography } from "@mui/material";
import { isRequiredLog } from "../../../log/guard";
import { formatCreationDate } from "../../../log/date";
import LogWithEmptyValueError from "../../../log/LogWithEmptyValueError";
import WorkoutLog from "../../../log/WorkoutLog";
import { useNavigate } from "@tanstack/react-router";

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
      <Typography>{formatCreationDate(log.createdAt)}</Typography>
    </CardContent>
    <CardActions>
      <Button onClick={() => navigate({ to: `/log/${log.id}` })}>Details</Button>
    </CardActions>
  </Card>
}