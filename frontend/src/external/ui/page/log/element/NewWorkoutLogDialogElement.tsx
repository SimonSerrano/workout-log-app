import { 
  Button, 
  Grid2, 
  TextField } from '@mui/material';
import { useForm } from '@tanstack/react-form';
import NewWorkoutLogForm 
  from '../../../../../app/port/in/dto/NewWorkoutLogForm';
import { 
  InteractiveBannerComponent, 
  InteractiveBannerTitleComponent } 
  from '../../../component/InteractiveBannerComponent';

interface NewWorkoutLogDialogProps {
  open: boolean;
  onClose(): void;
  onSubmit(newWorkout: NewWorkoutLogForm): Promise<void>;
}

export default function NewWorkoutLogDialogElement(
  props: NewWorkoutLogDialogProps) {
  const form = useForm<NewWorkoutLogForm>({
    defaultValues: {
      name: '',
    },
    onSubmit: ({value,}) => props.onSubmit(value),
  });

  return (
    <InteractiveBannerComponent open={props.open} onClose={() => {
      props.onClose();
      form.reset();
    }}>
      <InteractiveBannerTitleComponent>
        Create a new workout log
      </InteractiveBannerTitleComponent>
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
              name="name"
              validators={{
                onChange: ({value,}) => {
                  if(!value) {
                    return 'Title must not be empty';
                  }
                },
              }} 
            >
              {(field) =>(
                <TextField label="Workout name"
                  id={field.name}
                  name={field.name}
                  value={field.state.value} 
                  type="text"
                  error={Boolean(field.state.meta.errors.length)}
                  helperText={field.state.meta.errors.join(', ')}
                  onBlur={field.handleBlur} 
                  onChange={(e) => field.handleChange(e.target.value)}/>
              )}
            </form.Field>
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
            </Grid2>
          </Grid2>
        </Grid2>
      </form>
    </InteractiveBannerComponent>
  );
}
