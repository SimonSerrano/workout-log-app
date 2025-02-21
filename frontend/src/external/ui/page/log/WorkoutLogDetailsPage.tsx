import { 
  Button, 
  Card, 
  CardContent, 
  CircularProgress, 
  Grid2, 
  IconButton, 
  Typography } from '@mui/material';
import { useNavigate, useRouterState } from '@tanstack/react-router';
import { isWorkoutLog } from '../../../../app/domain/log/guard';
import { useEffect, useMemo, useState } from 'react';
import { useDeleteWorkoutLog } 
  from '../../context/workout/DeleteWorkoutLogContext';
import { useListTrainedExercises } 
  from '../../context/exercise/trained/ListTrainedExercisesContext';
import { useQuery } from '@tanstack/react-query';
import TrainedExerciseList from './element/TrainedExerciseList';
import { useCreateTrainedExercise } 
  from '../../context/exercise/trained/CreateTrainedExerciseContext';
import { useListExercises } from '../../context/exercise/ListExercisesContext';
import TrainedExerciseDialogElement 
  from './element/TrainedExerciseDialogElement';
import TrainedExercise from '../../../../app/domain/exercise/TrainedExercise';
import { useUpdateTrainedExercise } 
  from '../../context/exercise/trained/UpdateTrainedExerciseContext';
import { useDeleteTrainedExercise } 
  from '../../context/exercise/trained/DeleteTrainedExerciseContext';
import TrainedExerciseFormComponent 
  from '../../component/TrainedExerciseFormComponent';
import CalendarTodayIcon from '@mui/icons-material/CalendarToday';
import DeleteButtonComponent from '../../component/DeleteButtonComponent';
import AddIcon from '@mui/icons-material/Add';

export default function WorkoutLogDetailsPage() {
  const routerState = useRouterState();
  const navigate = useNavigate();
  const deleteWorkoutLog = useDeleteWorkoutLog();
  const listTrainedExercises = useListTrainedExercises();
  const createTrainedExercise = useCreateTrainedExercise();
  const updateTrainedExercise = useUpdateTrainedExercise();
  const listExercises = useListExercises();
  const deleteTrainedExercise = useDeleteTrainedExercise();

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

      return listTrainedExercises.list(log.id);
    },
  });

  const listExercisesQueryResult = useQuery({
    queryKey: ['exercises',],
    queryFn: async () => {
      return listExercises.list();
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
    deleteWorkoutLog.delete(log.id);
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
                  onEditClick={(trained) => {
                    setTrainedEdited(trained);
                    setNewTrainedOpen(true);
                  }}
                  onDeleteClick={async (trained) => {
                    await deleteTrainedExercise.delete(log.id, trained.id);
                    await listTrainedQueryResult.refetch();
                  }} />
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
                await createTrainedExercise.create(log.id, newTrained);
              }else {
                await updateTrainedExercise.update(
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
