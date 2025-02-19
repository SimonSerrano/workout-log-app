import Autocomplete, { createFilterOptions } from '@mui/material/Autocomplete';
import Exercise from '../../../app/domain/exercise/Exercise';
import TrainedExerciseFormDTO 
  from '../../../app/port/in/dto/TrainedExerciseForm';
import { Grid2, TextField, MenuItem, Button } from '@mui/material';
import { useForm } from '@tanstack/react-form';

export interface TrainedExerciseFormProps {
  onSubmit(newTrained: TrainedExerciseFormDTO): Promise<void>
  exercises: Exercise[]
  formData?: TrainedExerciseFormDTO
}

const defaultFormData: Required<TrainedExerciseFormDTO> = {
  exerciseId: '',
  sets: [],
};

interface RepetitionOptionType {
  reps: number;
  label: string;
}

const filter = createFilterOptions<RepetitionOptionType>();


export default function TrainedExerciseFormComponent(
  props: TrainedExerciseFormProps) {
  const form = useForm({
    defaultValues: props.formData ? 
      {...defaultFormData,...props.formData,} : {...defaultFormData, },
    onSubmit: ({value,}) => props.onSubmit(value),
  });


  return (
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
            name="exerciseId"
            validators={{
              onChange: ({value,}) => {
                if(!value) {
                  return 'An exercise must be selected';
                }
              },
            }}>
            {
              (field) => (
                <TextField 
                  id={field.name} 
                  name={field.name} 
                  label="Exercise" 
                  value={field.state.value} 
                  error={Boolean(field.state.meta.errors.length)}
                  helperText={field.state.meta.errors.join(', ')}
                  onBlur={field.handleBlur} 
                  onChange={(e) => field.handleChange(e.target.value)}
                  select>
                  {
                    props.exercises.map((exercise) => (
                      <MenuItem 
                        key={exercise.name} value={exercise.name}>
                        {exercise.name}
                      </MenuItem>
                    ))
                  }
                </TextField>
              )
            }
          </form.Field>
          <form.Field
            name="sets"
          >
            {(field) => (
              <Autocomplete
                value={field.state.value.map((v) => ({
                  label: new Intl.NumberFormat().format(v),
                  reps: v,
                }))}
                onChange={(_, newValue) => {
                  const validatedValues = newValue.map(
                    (v) => typeof v === 'string' ?  parseInt(v) : v.reps)
                    .filter(v => !isNaN(v));
                  field.handleChange(validatedValues);
                }}
                onBlur={field.handleBlur}
                filterOptions={(options, params) => {
                  const filtered = filter(options, params);

                  const { inputValue, } = params;
                  // Suggest the creation of a new value

                  if (inputValue !== '' && !isNaN(parseInt(inputValue))) {
                    filtered.push({
                      label: `Add "${inputValue}"`,
                      reps: parseInt(inputValue),
                    });
                  }

                  return filtered;
                }}
                selectOnFocus
                clearOnBlur
                handleHomeEndKeys
                id={field.name}
                options={[]}
                getOptionLabel={(option) => {
                  if(typeof option === 'string') {
                    return option;
                  }
                  return option.label;
                }}
                renderOption={(props, option) => {
                  const { key, ...optionProps } = props;
                  return (
                    <li key={key} {...optionProps}>
                      {option.label}
                    </li>
                  );
                }}
                // sx={{ width: 300, }}
                freeSolo
                multiple
                renderInput={(params) => (
                  <TextField {...params} 
                    label="Repetitions" />
                )}
              />
            )}
          </form.Field>
        </Grid2>
        <Grid2 alignSelf={'flex-end'}>
          <Grid2 container>
            <Grid2>
              <form.Subscribe 
                selector={
                  (state) => [state.canSubmit, state.isSubmitting,]}>
                {
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
              </form.Subscribe>
            </Grid2>
          </Grid2>
        </Grid2>
      </Grid2>
    </form>
  );
}