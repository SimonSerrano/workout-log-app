import { PropsWithChildren } from 'react';
import TrainedExerciseControllerImpl 
  from '../../../adapter/impl/TrainedExerciseControllerImpl';
import CreateTrainedExerciseUseCaseImpl 
  from '../../../usecase/impl/CreateTrainedExerciseUseCaseImpl';
import DeleteTrainedExerciseUseCaseImpl 
  from '../../../usecase/impl/DeleteTrainedExerciseUseCaseImpl';
import ListTrainedExercisesUseCaseImpl 
  from '../../../usecase/impl/ListTrainedExercisesUseCaseImpl';
import UpdateTrainedExerciseUseCaseImpl 
  from '../../../usecase/impl/UpdateTrainedExerciseUseCaseImpl';
import TrainedExerciseClientGatewayImpl 
  from '../../web/impl/TrainedExerciseClientGatewayImpl';
import TrainedExerciseClientImpl 
  from '../../web/impl/TrainedExerciseClientImpl';
import { TrainedExerciseControllerContext } 
  from './TrainedExerciseControllerContext';


const clientGW = new TrainedExerciseClientGatewayImpl(
  new TrainedExerciseClientImpl());

const controller = new TrainedExerciseControllerImpl(
  new CreateTrainedExerciseUseCaseImpl(clientGW),
  new DeleteTrainedExerciseUseCaseImpl(clientGW),
  new ListTrainedExercisesUseCaseImpl(clientGW),
  new UpdateTrainedExerciseUseCaseImpl(clientGW)
);

export default function 
TrainedExerciseControllerProvider(props: PropsWithChildren) {


  return (
    <TrainedExerciseControllerContext.Provider value={controller}>
      {props.children}
    </TrainedExerciseControllerContext.Provider>
  );
}