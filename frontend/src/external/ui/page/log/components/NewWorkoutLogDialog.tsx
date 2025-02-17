import { Button, Dialog, DialogTitle, Grid2, TextField } from '@mui/material';
import { useForm } from '@tanstack/react-form';
import NewWorkoutLogForm from '../../../dto/NewWorkoutLogForm';

interface NewWorkoutLogDialogProps {
  open: boolean;
  onClose(): void;
  onSubmit(newWorkout: NewWorkoutLogForm): Promise<void>;
}

export default function NewWorkoutLogDialog(props: NewWorkoutLogDialogProps) {
  const form = useForm<NewWorkoutLogForm>({
    defaultValues: {
      title: '',
    },
    onSubmit: ({value,}) => props.onSubmit(value),
  });

  return (
    <Dialog open={props.open} onClose={props.onClose}>
      <DialogTitle>Create a new workout log</DialogTitle>
      <form onSubmit={(e) => {
        e.preventDefault();
        e.stopPropagation();
        form.handleSubmit();
      }}>
        <Grid2
          container
          direction="column"
          padding={2}
          alignItems={'center'}
          spacing={2}
        >
          <Grid2>
            <form.Field 
              name="title"
              validators={{
                onChange: ({value,}) => {
                  if(!value) {
                    return 'Title must not be empty';
                  }
                },
              }} 
              children={(field) =>(
                <TextField label="Workout title"
                  id={field.name}
                  name={field.name}
                  value={field.state.value} 
                  type="text"
                  error={Boolean(field.state.meta.errors.length)}
                  helperText={field.state.meta.errors.join(', ')}
                  onBlur={field.handleBlur} 
                  onChange={(e) => field.handleChange(e.target.value)}/>
              )}/>
          </Grid2>
          <Grid2 alignSelf={'flex-end'}>
            <Grid2 container>
              <Grid2>
                <form.Subscribe 
                  selector={(state) => [state.canSubmit, state.isSubmitting,]}
                  children={
                    ([canSubmit, isSubmitting,]) => (
                      <Button 
                        type="submit"
                        disabled={!canSubmit} 
                        loading={isSubmitting} 
                        loadingPosition="end"
                      >
                        Confirm
                      </Button>
                    )
                  }
                />
              </Grid2>
              <Grid2>
                <Button onClick={props.onClose}>Cancel</Button>
              </Grid2>
            </Grid2>
          </Grid2>
        </Grid2>
      </form>
    </Dialog>
  );
}
