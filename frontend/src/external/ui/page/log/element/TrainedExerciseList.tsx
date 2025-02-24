import { 
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
  children(trained: TrainedExercise, index: number): JSX.Element
}

export default function TrainedExerciseList(props: TrainedExerciseListProps) {


  if(props.isPending) {
    return <CircularProgress />;
  }

  if(props.isError && props.error) {
    return <Typography>{props.error.message}</Typography>;
  }

  return <Grid2 container direction={'column'} spacing={4}>
    {props.data?.map(props.children)}
  </Grid2>;
}