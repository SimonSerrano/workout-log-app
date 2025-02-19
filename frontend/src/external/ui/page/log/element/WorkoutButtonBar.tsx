import { DialogActions, DialogTitle } from '@mui/material';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import Grid2 from '@mui/material/Grid2';
import { useState } from 'react';

export interface WorkoutButtonBarProps {
  onBackClick(): void;
  onDeleteClick(): Promise<void>;
}

export default function WorkoutButtonBar(props: WorkoutButtonBarProps) {

  const [confirmOpen, setConfirmOpen,] = useState(false);
  const [deleteLoading, setDeleteLoading,] = useState(false);

  return <Grid2 container>
    <Grid2>
      <Button onClick={() => props.onBackClick()}>Back</Button>
    </Grid2>
    <Grid2>
      <Button 
        disabled={deleteLoading} 
        loading={deleteLoading} 
        color="error" 
        onClick={() => setConfirmOpen(true)}>Delete</Button>
    </Grid2>
    <Dialog open={confirmOpen}>
      <DialogTitle>Are you sure ?</DialogTitle>
      <DialogActions>
        <Button onClick={() => {
          setConfirmOpen(false);
          setDeleteLoading(true);
          props.onDeleteClick().finally(() => setDeleteLoading(false));
        }}>Yes</Button>
        <Button onClick={() => setConfirmOpen(false)}>No</Button>
      </DialogActions>
    </Dialog>
  </Grid2>;
}