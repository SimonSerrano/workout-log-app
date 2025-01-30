import { Button, CircularProgress, Grid2 } from '@mui/material';
import NewWorkoutLogDialog from './components/NewWorkoutLogDialog';
import { useSignal } from '@preact/signals-react';
import WorkoutLogList from './components/WorkoutLogList';
import { useQuery } from '@tanstack/react-query';
import { useListWorkoutLogs } from '../../../../app/context/ListWorkoutLogsContext';
import WorkoutLogElement from './components/WorkoutLogElement';
import { useNavigate } from '@tanstack/react-router';
import WorkoutLog from '../../../../domain/log/WorkoutLog';

export default function WorkoutLogPage() {
  const newWorkoutDialogOpen = useSignal<boolean>(false);
  const listWorkoutLogs = useListWorkoutLogs();
  const navigate = useNavigate();

  const {
    isPending,
    isError,
    data: logs,
    error,
  } = useQuery({
    queryKey: ['logs'],
    queryFn: listWorkoutLogs.listWorkouts.bind(listWorkoutLogs),
  });

  if (error) {
    console.error(error);
  }

  const handleDetailsClick = (log: WorkoutLog) => {
    const state: Record<string, WorkoutLog> = { log };
    navigate({ to: '/log/$logId', params: { logId: log.id }, state });
  };

  return (
    <Grid2 container direction={'column'}>
      <Grid2>
        <Button onClick={() => (newWorkoutDialogOpen.value = true)}>
          Add workout log
        </Button>
        <NewWorkoutLogDialog
          open={newWorkoutDialogOpen.value}
          onClose={() => (newWorkoutDialogOpen.value = false)}
        />
      </Grid2>
      <Grid2>
        {isPending ? (
          <CircularProgress />
        ) : (
          <WorkoutLogList
            logs={isError ? [] : logs}
            listElementComponent={(log) => (
              <WorkoutLogElement
                log={log}
                onDetailsClick={handleDetailsClick}
              />
            )}
          />
        )}
      </Grid2>
    </Grid2>
  );
}
