import { useQuery } from "@tanstack/react-query";
import { useGetLogDetails } from "../../../../app/context/GetLogDetailsContext"
import { Route } from "../../../../routes/log/$logId/index.lazy";
import { Button, CircularProgress, Grid2, Typography } from "@mui/material";
import { useNavigate } from "@tanstack/react-router";

export default function WorkoutLogDetailsPage() {

  const { logId } = Route.useParams();
  const navigate = useNavigate();

  const getLogDetails = useGetLogDetails();

  const { isPending, isError, data: log, error } = useQuery({queryKey: ['logs/' + logId], queryFn: () => {
    return getLogDetails.getLogDetails(logId);
  }});

  if(isPending) {
    return <CircularProgress />
  }

  if(isError) {
    console.error(error);
  }

  return <Grid2 container direction="column">
    <Button onClick={() => navigate({to: '/log'})}>Back</Button>
    <Grid2>
      <Typography>{log?.title}</Typography>
    </Grid2>
    <Grid2>
      <Typography>{log?.createdAt}</Typography>
    </Grid2>
  </Grid2>
}