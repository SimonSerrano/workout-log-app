import { PropsWithChildren } from 'react';
import WorkoutLogClientImpl from '../../web/WorkoutLogClientImpl';
import WorkoutLogResponseMapper 
  from '../../../app/port/out/mapper/WorkoutLogResponseMapper';
import { CreateWorkoutLogContext } from './CreateWorkoutLogContext';
import CreateWorkoutLogUseCase from '../../../app/usecase/CreateWorkoutLogUseCase';

export default function CreateWorkoutLogProvider(props: PropsWithChildren) {
  const useCase = new CreateWorkoutLogUseCase(
    new WorkoutLogClientImpl(),
    new WorkoutLogResponseMapper()
  );

  return (
    <CreateWorkoutLogContext.Provider value={useCase}>
      {props.children}
    </CreateWorkoutLogContext.Provider>
  );
}
