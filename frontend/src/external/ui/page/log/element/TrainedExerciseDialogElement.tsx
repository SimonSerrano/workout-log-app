import { 
  Dialog, 
  DialogContent, 
  DialogTitle } from '@mui/material';
import { PropsWithChildren } from 'react';

export interface TrainedExerciseDialogProps {
  new?: boolean
  open: boolean
  onClose(): void
}





export default 
function TrainedExerciseDialogElement(
  props: PropsWithChildren<TrainedExerciseDialogProps>) {

  return (
    <Dialog open={props.open} onClose={() => {
      props.onClose();
    }}>
      <DialogTitle>{!props.new ? 
        'Update this trained exercise' : 'Create a new trained exercise'}
      </DialogTitle>
      <DialogContent>
        {props.children}
      </DialogContent>
    </Dialog>
  );

}