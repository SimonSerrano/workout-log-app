import { Button, Dialog, DialogTitle, Grid2, TextField } from "@mui/material";
import { useForm } from "@tanstack/react-form";

interface NewWorkoutLogDialogProps {
  open: boolean;
  onClose(): void;
}

export default function NewWorkoutLogDialog(props: NewWorkoutLogDialogProps) {

  const form = useForm();


  return <Dialog open={props.open} onClose={props.onClose}>
    <DialogTitle>Create a new workout log</DialogTitle>
    <Grid2 container direction="column" padding={2} alignItems={"center"} spacing={2}>
      <Grid2>
        <TextField label="Workout title" />
      </Grid2>
      <Grid2 alignSelf={"flex-end"}>
        <Grid2 container>
          <Grid2>
            <Button>Confirm</Button>
          </Grid2>
          <Grid2>
            <Button onClick={props.onClose}>Cancel</Button>
          </Grid2>
        </Grid2>
      </Grid2>
    </Grid2>
  </Dialog>
}