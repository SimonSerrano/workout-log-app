import { 
  Button, 
  Card, 
  CardContent, 
  CircularProgress, 
  Grid2, 
  IconButton, 
  Typography } from '@mui/material';
import { useNavigate, useRouterState } from '@tanstack/react-router';
import { isWorkoutLog } from '../../../entity/guard';
import { useEffect, useMemo, useState } from 'react';
import { useQuery } from '@tanstack/react-query';
import TrainedExerciseList 
  from '../../../../trainedexercise/external/react/element/TrainedExerciseList';
import CalendarTodayIcon 
  from '@mui/icons-material/CalendarToday';
import DeleteButtonComponent 
  from '../../../../shared/external/react/component/DeleteButtonComponent';
import AddIcon from '@mui/icons-material/Add';
import { useWorkoutController } from '../context/WorkoutControllerContext';
import { useExerciseController } 
  from '../../../../exercise/external/react/context/ExerciseControllerContext';
import {TrainedExerciseFormComponent} from '../../../../shared';
import TrainedExercise 
  from '../../../../trainedexercise/entity/TrainedExercise';
import { 
  useTrainedExerciseController, 
  TrainedExerciseListElement, 
  TrainedExerciseDialogElement } from '../../../../trainedexercise';

export default function WorkoutLogDetailsPage() {
  const routerState = useRouterState();
  const navigate = useNavigate();
  const workoutController = useWorkoutController();
  const trainedExerciseController = useTrainedExerciseController();
  const exerciseController = useExerciseController();

  const [newTrainedOpen, setNewTrainedOpen,] = useState(false);
  const [trainedEdited, setTrainedEdited,] = 
  useState<undefined | TrainedExercise>(undefined);


  

  const log = useMemo(() => {
    if (
      'log' in routerState.location.state &&
      isWorkoutLog(routerState.location.state.log)
    ) {
      return routerState.location.state.log;
    }

    return null;
  }, [routerState,]);

  const listTrainedQueryResult = useQuery({
    queryKey: [`log/${log?.id}/trained`,],
    queryFn: async () => {
      if(!log) {
        return [];
      }

      return trainedExerciseController.list(log.id);
    },
  });

  const listExercisesQueryResult = useQuery({
    queryKey: ['exercises',],
    queryFn: async () => {
      return exerciseController.list();
    },
  });

  useEffect(() => {
    if (log === null) {
      navigate({ to: '/log', });
    }
  }, [log, navigate,]);

  if (!log) {
    return <CircularProgress />;
  }

  

  const handleDelete = async () => {
    workoutController.delete(log.id);
    navigate({to: '/log',});
  };

  return (
    <Grid2 container direction="column" spacing={4} alignItems="stretch">
      <Grid2 alignSelf={'flex-end'}>
        <Button onClick={() =>  navigate({ to: '/log', })}>Back</Button>
      </Grid2>
      <Grid2>
        <Card>
          <CardContent>
            <Typography variant="h5" gutterBottom>{log.name}</Typography>
            <Grid2 container direction="row" spacing={2}>
              <Grid2><CalendarTodayIcon/></Grid2>
              <Grid2><Typography 
                variant="subtitle1" 
                gutterBottom>{log.createdAt}</Typography></Grid2>
            </Grid2>
          </CardContent>
        </Card>
      </Grid2>
      <Grid2>
        <Card>
          <CardContent>
            <Grid2 container 
              direction={'column'} 
            >
              <Grid2>
                <Grid2 container
                  justifyContent={'space-between'}>
                  <Grid2>
                    <Typography variant="h6">Trained exercise</Typography>
                  </Grid2>
                  <Grid2>
                    <IconButton 
                      disabled={
                        listExercisesQueryResult.isPending 
                || listExercisesQueryResult.isError}
                      loading={listExercisesQueryResult.isPending}
                      onClick={() => setNewTrainedOpen(true)}>
                      <AddIcon/></IconButton>
                  </Grid2>
                </Grid2>
              </Grid2>
              <Grid2>
                <TrainedExerciseList 
                  {...listTrainedQueryResult} 
                >
                  {
                    (trained) => <TrainedExerciseListElement 
                      key={trained.id} 
                      trained={trained} onEditClick={(trained) => {
                        setTrainedEdited(trained);
                        setNewTrainedOpen(true);
                      }}
                      onDeleteClick={async (trained) => {
                        await trainedExerciseController.delete(
                          log.id, 
                          trained.id);
                        await listTrainedQueryResult.refetch();
                      }}/>
                  }
                </TrainedExerciseList>
              </Grid2>
            </Grid2>
          </CardContent>
        </Card>
      </Grid2>
      <Grid2 alignSelf={'center'} >
        <DeleteButtonComponent 
          onDeleteClick={handleDelete}/>
      </Grid2>
      {
        listExercisesQueryResult.data && 
        <TrainedExerciseDialogElement 
          new={!trainedEdited}
          open={newTrainedOpen} 
          onClose={() => {
            setTrainedEdited(undefined);
            setNewTrainedOpen(false);
          }}
        >
          <TrainedExerciseFormComponent
            onSubmit={async (newTrained) => {
              if(!trainedEdited) {
                await trainedExerciseController.create(log.id, newTrained);
              }else {
                await trainedExerciseController.update(
                  log.id, 
                  trainedEdited.id, 
                  newTrained);
              }
              await listTrainedQueryResult.refetch();
  
              setNewTrainedOpen(false);
              setTrainedEdited(undefined);
            }}
            exercises={listExercisesQueryResult.data}
            formData={trainedEdited && {
              exerciseId: trainedEdited.exercise.name,
              sets: trainedEdited.sets.map((s) => s.reps),
              weight: trainedEdited.weight,
            }}
          />
        </TrainedExerciseDialogElement>
      }
      
    </Grid2>
  );
}
