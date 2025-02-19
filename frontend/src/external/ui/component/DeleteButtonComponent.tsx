import { Grid2, IconButton } from '@mui/material';
import Button from '@mui/material/Button';
import { useMemo, useState } from 'react';
import DeleteIcon from '@mui/icons-material/Delete';
import DeleteForeverIcon from '@mui/icons-material/DeleteForever';
import { InteractiveBannerComponent, 
  InteractiveBannerTitleComponent } 
  from './InteractiveBannerComponent';

export interface WorkoutButtonBarProps {
  onDeleteClick(): Promise<void>;
  iconOnly?: boolean;
}

export default function DeleteButtonComponent(props: WorkoutButtonBarProps) {

  const [confirmOpen, setConfirmOpen,] = useState(false);
  const [deleteLoading, setDeleteLoading,] = useState(false);



  const button = useMemo(() => {
    if(props.iconOnly) {
      return <IconButton
        disabled={deleteLoading} 
        loading={deleteLoading} 
        color="error" 
        onClick={() => setConfirmOpen(true)}><DeleteIcon/></IconButton>;
    }

    return <Button
      variant="contained" 
      disabled={deleteLoading} 
      loading={deleteLoading} 
      color="error" 
      endIcon={<DeleteIcon/>}
      onClick={() => setConfirmOpen(true)}>Delete</Button>;
  }, [deleteLoading, props.iconOnly,]);

  return <>
    {button}
    <InteractiveBannerComponent 
      open={confirmOpen} 
      onClose={() => setConfirmOpen(false)}>
      <InteractiveBannerTitleComponent>
        Are you sure ?
      </InteractiveBannerTitleComponent>
      <Grid2 container justifyContent={'flex-end'} spacing={2}>
        <Grid2>
          <Button 
            variant="contained"
            color="error"
            endIcon={<DeleteForeverIcon/>}
            onClick={() => {
              setConfirmOpen(false);
              setDeleteLoading(true);
              props.onDeleteClick().finally(() => setDeleteLoading(false));
            }}>Yes</Button>
        </Grid2>
        <Grid2>
          <Button onClick={() => setConfirmOpen(false)}>No</Button>
        </Grid2>
      </Grid2>
      
    </InteractiveBannerComponent>
  </>;
}