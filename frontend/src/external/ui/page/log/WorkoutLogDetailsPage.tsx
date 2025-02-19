import { Button, CircularProgress, Grid2, Typography } from '@mui/material';
import { useNavigate, useRouterState } from '@tanstack/react-router';
import { isWorkoutLog } from '../../../../app/domain/log/guard';
import { useEffect, useMemo, useState } from 'react';
import { useDeleteWorkoutLog } 
  from '../../context/workout/DeleteWorkoutLogContext';
import WorkoutButtonBar from './components/WorkoutButtonBar';
import { useListTrainedExercises } 
  from '../../context/exercise/trained/ListTrainedExercisesContext';
import { useQuery } from '@tanstack/react-query';
import TrainedExerciseList from './components/TrainedExerciseList';
import { useCreateTrainedExercise } 
  from '../../context/exercise/trained/CreateTrainedExerciseContext';
import { useListExercises } from '../../context/exercise/ListExercisesContext';
import NewTrainedExerciseDialog from './components/NewTrainedExerciseDialog';
import TrainedExercise from '../../../../app/domain/exercise/TrainedExercise';
import { useUpdateTrainedExercise } 
  from '../../context/exercise/trained/UpdateTrainedExerciseContext';
import { useDeleteTrainedExercise } 
  from '../../context/exercise/trained/DeleteTrainedExerciseContext';

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
    <Grid2 container direction="column">
      <Grid2>
        <WorkoutButtonBar 
          onBackClick={() => navigate({ to: '/log', })} 
          onDeleteClick={handleDelete}/>
      </Grid2>
      <Grid2>
        <Typography>{log.name}</Typography>
      </Grid2>
      <Grid2>
        <Typography>{log.createdAt}</Typography>
      </Grid2>
      <Grid2>
        <Grid2 container direction={'column'}>
          <Grid2>
            <Grid2 container>
              <Grid2>
                <Typography>Trained exercise</Typography>
              </Grid2>
              <Grid2>
                <Button 
                  disabled={
                    listExercisesQueryResult.isPending 
                || listExercisesQueryResult.isError}
                  loading={listExercisesQueryResult.isPending}
                  onClick={() => setNewTrainedOpen(true)}>
                  Add exercise</Button>
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
      </Grid2>
      {
        listExercisesQueryResult.data && 
        <NewTrainedExerciseDialog 
          open={newTrainedOpen} 
          onClose={() => {
            setTrainedEdited(undefined);
            setNewTrainedOpen(false);
          }}
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
          }} />
      }
      
    </Grid2>
  );
}
