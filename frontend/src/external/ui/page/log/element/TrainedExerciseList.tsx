import { 
  Button, 
  Chip, 
  CircularProgress, 
  Grid2, 
  Typography } from '@mui/material';
import TrainedExercise 
  from '../../../../../app/domain/exercise/TrainedExercise';

export interface TrainedExerciseListProps {
  isPending: boolean,
  isError: boolean,
  data?: TrainedExercise[]
  error: Error | null
  onEditClick(trained: TrainedExercise): void
  onDeleteClick(trained: TrainedExercise): void
}

export default function TrainedExerciseList(props: TrainedExerciseListProps) {


  if(props.isPending) {
    return <CircularProgress />;
  }

  if(props.isError && props.error) {
    return <Typography>{props.error.message}</Typography>;
  }

  return <Grid2 container direction={'column'}>
    {props.data?.map((trained) => (
      <Grid2 key={trained.id}>
        <Grid2 container>
          <Grid2>
            <Typography>{trained.exercise.name}</Typography>
          </Grid2>
          {
            trained.sets.map((set) => (
              <Grid2 key={set.id}>
                <Chip label={set.reps} />
              </Grid2>
            ))
          }
          <Grid2>
            <Button onClick={() => props.onEditClick(trained)}>Edit</Button>
          </Grid2>
          <Grid2>
            <Button onClick={() => props.onDeleteClick(trained)}>Delete</Button>
          </Grid2>
        </Grid2>
      </Grid2>
    ))}
  </Grid2>;
}