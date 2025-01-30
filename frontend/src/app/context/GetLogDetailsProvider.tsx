import { PropsWithChildren } from 'react';
import WorkoutLogClient from '../../adapter/out/WorkoutLogClient';
import WorkoutLogResponseMapper from '../port/out/mapper/WorkoutLogResponseMapper';
import getLogDetailsUseCase from '../usecase/GetLogDetailsUseCase';
import { GetLogDetailsContext } from './GetLogDetailsContext';

export default function GetLogDetailsProvider(props: PropsWithChildren) {
  const useCase = new getLogDetailsUseCase(
    new WorkoutLogClient(),
    new WorkoutLogResponseMapper(),
  );

  return (
    <GetLogDetailsContext.Provider value={useCase}>
      {props.children}
    </GetLogDetailsContext.Provider>
  );
}
