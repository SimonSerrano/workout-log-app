import { Paper, Typography, Backdrop, Slide } from '@mui/material';
import TrapFocus from '@mui/material/Unstable_TrapFocus';
import { PropsWithChildren } from 'react';


export interface InteractiveBannerComponentProps {
  open: boolean
  // eslint-disable-next-line @typescript-eslint/no-empty-object-type
  onClose?: ((event: {}, reason: 'backdropClick' | 'escapeKeyDown') => void)
}

export function InteractiveBannerTitleComponent(props: PropsWithChildren) {
  return <Typography sx={{ fontWeight: 'bold', }}>
    {props.children}
  </Typography>;
}

export function InteractiveBannerComponent(
  props: PropsWithChildren<InteractiveBannerComponentProps>) {




  return <Backdrop
    sx={(theme) => ({ zIndex: theme.zIndex.drawer + 1, })}
    open={props.open}
    onClick={(e) => {
      if(props.onClose) {
        props.onClose(e, 'backdropClick');
      }
    }}
  >
    <TrapFocus open disableAutoFocus disableEnforceFocus>
      <Slide direction="up" appear={false} in={props.open}>
        <Paper
          role="dialog"
          aria-modal="false"
          variant="elevation"
          tabIndex={-1}
          sx={{
            position: 'fixed',
            bottom: 0,
            left: 0,
            right: 0,
            m: 0,
            p: 2,
            borderWidth: 0,
            borderTopWidth: 1,
          }}
          onClick={(e) => {
            e.stopPropagation();
          }}
        >
          {props.open && props.children}
        </Paper>
      </Slide>
    </TrapFocus>
  </Backdrop>
  ;
}