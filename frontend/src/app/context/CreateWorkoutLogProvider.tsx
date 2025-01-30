import { PropsWithChildren } from 'react';
import WorkoutLogClient from '../../adapter/out/WorkoutLogClient';
import WorkoutLogResponseMapper 
  from '../port/out/mapper/WorkoutLogResponseMapper';
import { CreateWorkoutLogContext } from './CreateWorkoutLogContext';
import CreateWorkoutLogUseCase from '../usecase/CreateWorkoutLogUseCase';

export default function CreateWorkoutLogProvider(props: PropsWithChildren) {
  const useCase = new CreateWorkoutLogUseCase(
    new WorkoutLogClient(),
    new WorkoutLogResponseMapper()
  );

  return (
    <CreateWorkoutLogContext.Provider value={useCase}>
      {props.children}
    </CreateWorkoutLogContext.Provider>
  );
}
