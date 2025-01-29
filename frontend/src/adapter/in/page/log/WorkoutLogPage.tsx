import { Button, CircularProgress, Grid2 } from "@mui/material";
import NewWorkoutLogDialog from "./components/NewWorkoutLogDialog";
import { useSignal } from "@preact/signals-react";
import WorkoutLogList from "./components/WorkoutLogList";
import { useQuery } from "@tanstack/react-query";
import { useListWorkoutLogs } from "../../../../app/context/ListWorkoutLogsContext";

export default function WorkoutLogPage() {

  const newWorkoutDialogOpen = useSignal<boolean>(false);
  const workoutLogClient = useListWorkoutLogs();

  const { isPending, isError, data: logs, error } = useQuery({queryKey: ['logs'], queryFn: workoutLogClient.listWorkouts.bind(workoutLogClient)});


  if(error) {
    console.error(error);
  }


  return <Grid2 container direction={'column'}>
    <Grid2>
      <Button onClick={() => newWorkoutDialogOpen.value = true}>Add workout log</Button>
      <NewWorkoutLogDialog open={newWorkoutDialogOpen.value} onClose={() => newWorkoutDialogOpen.value = false}/>
    </Grid2>
    <Grid2>
      {
        isPending ? 
        <CircularProgress />
        :
        <WorkoutLogList logs={isError ? [] : logs}/>
      }
    </Grid2>
  </Grid2>
}