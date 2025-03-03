import { Button, CircularProgress, Grid2 } from '@mui/material';
import NewWorkoutLogDialogElement from '../element/NewWorkoutLogDialogElement';
import { useSignal } from '@preact/signals-react';
import WorkoutLogList from '../element/WorkoutLogList';
import { useQuery } from '@tanstack/react-query';
import WorkoutLogElement from '../element/WorkoutLogElement';
import { useNavigate } from '@tanstack/react-router';
import { useWorkoutController } from '../context/WorkoutControllerContext';
import WorkoutLog from '../../../entity/WorkoutLog';
import NewWorkoutLogForm from '../../../adapter/dto/NewWorkoutLogForm';


export default function WorkoutLogPage() {
  const newWorkoutDialogOpen = useSignal<boolean>(false);
  const workoutController = useWorkoutController();
  const navigate = useNavigate();

  const {
    isPending,
    isError,
    data: logs,
    error,
  } = useQuery({
    queryKey: ['logs',],
    queryFn: workoutController.list.bind(workoutController),
  });

  if (error) {
    console.error(error);
  }

  const handleDetailsClick = (log: WorkoutLog) => {
    const state: Record<string, WorkoutLog> = { log, };
    navigate({ to: '/log/$logId', params: { logId: log.id, }, state, });
  };

  const handleOnSubmitNewWorkout = 
  async (log: NewWorkoutLogForm): Promise<void> => {
    const returnedWorkoutLog = await workoutController.create(log);
    const state: Record<string, WorkoutLog> = { log: returnedWorkoutLog, };
    navigate({ 
      to: '/log/$logId', 
      params: {logId: returnedWorkoutLog.id,}, 
      state,});
  };

  return (
    <Grid2 container direction={'column'}>
      <Grid2>
        <Button onClick={() => (newWorkoutDialogOpen.value = true)}>
          Add workout log
        </Button>
        <NewWorkoutLogDialogElement
          open={newWorkoutDialogOpen.value}
          onClose={() => (newWorkoutDialogOpen.value = false)}
          onSubmit={handleOnSubmitNewWorkout}
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
