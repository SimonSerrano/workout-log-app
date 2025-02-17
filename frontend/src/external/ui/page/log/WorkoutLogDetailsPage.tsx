import { Button, CircularProgress, Grid2, Typography } from '@mui/material';
import { useNavigate, useRouterState } from '@tanstack/react-router';
import { isWorkoutLog } from '../../../../app/domain/log/guard';
import { useEffect, useMemo } from 'react';

export default function WorkoutLogDetailsPage() {
  const routerState = useRouterState();
  const navigate = useNavigate();

  const log = useMemo(() => {
    if (
      'log' in routerState.location.state &&
      isWorkoutLog(routerState.location.state.log)
    ) {
      return routerState.location.state.log;
    }

    return null;
  }, [routerState,]);

  useEffect(() => {
    if (log === null) {
      navigate({ to: '/log', });
    }
  }, [log, navigate,]);

  if (!log) {
    return <CircularProgress />;
  }

  return (
    <Grid2 container direction="column">
      <Button onClick={() => navigate({ to: '/log', })}>Back</Button>
      <Grid2>
        <Typography>{log.name}</Typography>
      </Grid2>
      <Grid2>
        <Typography>{log.createdAt}</Typography>
      </Grid2>
    </Grid2>
  );
}
