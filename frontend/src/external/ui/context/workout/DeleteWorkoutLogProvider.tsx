import { PropsWithChildren } from 'react';
import WorkoutLogClientImpl from '../../../web/WorkoutLogClientImpl';
import DeleteWorkoutLogUseCase from 
  '../../../../app/usecase/DeleteWorkoutLogUseCase';
import { DeleteWorkoutLogContext } from './DeleteWorkoutLogContext';

export default function DeleteWorkoutLogProvider(props: PropsWithChildren) {
  const useCase = new DeleteWorkoutLogUseCase(new WorkoutLogClientImpl());

  return (
    <DeleteWorkoutLogContext.Provider value={useCase}>
      {props.children}
    </DeleteWorkoutLogContext.Provider>
  );
}
