import { 
  Chip, 
  CircularProgress, 
  Grid2, 
  Icon, 
  IconButton, 
  Typography } from '@mui/material';
import TrainedExercise 
  from '../../../../../app/domain/exercise/TrainedExercise';
import DeleteButtonComponent from '../../../component/DeleteButtonComponent';
import EditIcon from '@mui/icons-material/Edit';
import FitnessCenterIcon from '@mui/icons-material/FitnessCenter';

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
        <Grid2 container direction={'column'}>
          <Grid2>
            <Grid2 container 
              spacing={2} 
              alignItems={'center'} 
              justifyContent={'space-between'}>
              <Grid2>
                <Grid2 container 
                  spacing={2}
                  alignItems={'center'} 
                  justifyContent={'space-between'}
                >
                  <Grid2>
                    <Typography 
                      color={'primary'}
                      sx={{fontWeight: 'bold',}}
                    >{trained.exercise.name}</Typography>
                  </Grid2>
                  {
                    trained.weight && (
                      <>
                        <Grid2>
                          <Icon>
                            <FitnessCenterIcon />
                          </Icon>
                        </Grid2>
                        <Grid2>
                          <Typography color="secondary">
                            {trained.weight}
                          </Typography>
                        </Grid2>
                      </>
                    )
                  }
                </Grid2>
              </Grid2>
              <Grid2 justifySelf={'flex-end'}>
                <Grid2 container spacing={1}>
                  <Grid2>
                    <IconButton 
                      onClick={() => props.onEditClick(trained)}>
                      <EditIcon/>
                    </IconButton>
                  </Grid2>
                  <Grid2>
                    <DeleteButtonComponent iconOnly
                      onDeleteClick={async () => props.onDeleteClick(trained)}>
                    </DeleteButtonComponent>
                  </Grid2>
                </Grid2>
              </Grid2>
            </Grid2>
          </Grid2>
          <Grid2>
            <Grid2 container spacing={2} alignItems={'center'}>
              <Grid2>
                <Typography>Reps: </Typography>
              </Grid2>
              {
                trained.sets.map((set) => (
                  <Grid2 key={set.id}>
                    <Chip color="secondary" label={set.reps} />
                  </Grid2>
                ))
              }
            </Grid2>
          </Grid2>
        </Grid2>
        
      </Grid2>
    ))}
  </Grid2>;
}