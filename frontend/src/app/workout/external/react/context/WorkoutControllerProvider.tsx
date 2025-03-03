import { PropsWithChildren } from 'react';
import WorkoutLogClientImpl 
  from '../../web/impl/WorkoutLogClientImpl';
import { WorkoutControllerContext } from './WorkoutControllerContext';
import CreateWorkoutLogUseCaseImpl 
  from '../../../usecase/impl/CreateWorkoutLogUseCaseImpl';
import WorkoutControllerImpl 
  from '../../../adapter/impl/WorkoutControllerImpl';
import WorkoutClientGatewayImpl 
  from '../../web/impl/WorkoutClientGatewayImpl';
import DeleteWorkoutLogUseCaseImpl 
  from '../../../usecase/impl/DeleteWorkoutLogUseCaseImpl';
import GetLogDetailsUseCaseImpl 
  from '../../../usecase/impl/GetLogDetailsUseCaseImpl';
import ListWorkoutLogsUseCaseImpl 
  from '../../../usecase/impl/ListWorkoutLogsUseCaseImpl';

const clientGateway = new WorkoutClientGatewayImpl(
  new WorkoutLogClientImpl()
);

const controller = new WorkoutControllerImpl(
  new CreateWorkoutLogUseCaseImpl(clientGateway),
  new DeleteWorkoutLogUseCaseImpl(clientGateway),
  new GetLogDetailsUseCaseImpl(clientGateway),
  new ListWorkoutLogsUseCaseImpl(clientGateway)
);

export default function WorkoutControllerProvider(props: PropsWithChildren) {
  

  return (
    <WorkoutControllerContext.Provider value={controller}>
      {props.children}
    </WorkoutControllerContext.Provider>
  );
}
