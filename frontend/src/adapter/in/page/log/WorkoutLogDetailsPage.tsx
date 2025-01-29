import { useQuery } from "@tanstack/react-query";
import { useGetLogDetails } from "../../../../app/context/GetLogDetailsContext"
import { Route } from "../../../../routes/log/$logId/index.lazy";
import { CircularProgress, Grid2, Typography } from "@mui/material";

export default function WorkoutLogDetailsPage() {

  const { logId } = Route.useParams();

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
    <Grid2>
      <Typography>{log?.title}</Typography>
    </Grid2>
    <Grid2>
      <Typography>{log?.createdAt}</Typography>
    </Grid2>
  </Grid2>
}