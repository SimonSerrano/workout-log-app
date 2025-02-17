import { PropsWithChildren } from 'react';
import WorkoutLogClient from '../../web/WorkoutLogClient';
import WorkoutLogResponseMapper 
  from '../../../app/port/out/mapper/WorkoutLogResponseMapper';
import getLogDetailsUseCase from '../../../app/usecase/GetLogDetailsUseCase';
import { GetLogDetailsContext } from './GetLogDetailsContext';

export default function GetLogDetailsProvider(props: PropsWithChildren) {
  const useCase = new getLogDetailsUseCase(
    new WorkoutLogClient(),
    new WorkoutLogResponseMapper()
  );

  return (
    <GetLogDetailsContext.Provider value={useCase}>
      {props.children}
    </GetLogDetailsContext.Provider>
  );
}
