import { PropsWithChildren } from 'react';
import { InteractiveBannerComponent, InteractiveBannerTitleComponent } 
  from '../../../../shared/external/react/component/InteractiveBannerComponent';

export interface TrainedExerciseDialogProps {
  new?: boolean
  open: boolean
  onClose(): void
}


export default 
function TrainedExerciseDialogElement(
  props: PropsWithChildren<TrainedExerciseDialogProps>) {

  return (
    <InteractiveBannerComponent open={props.open} onClose={() => {
      props.onClose();
    }}>
      <InteractiveBannerTitleComponent>{!props.new ? 
        'Update this trained exercise' : 'Create a new trained exercise'}
      </InteractiveBannerTitleComponent>
      {props.children}
    </InteractiveBannerComponent>
  );

}