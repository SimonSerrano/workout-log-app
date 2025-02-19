import { PropsWithChildren } from 'react';
import WorkoutLogClientImpl from '../../../../web/WorkoutLogClientImpl';
import WorkoutLogResponseMapper 
  from '../../../../../app/port/out/mapper/WorkoutLogResponseMapper';
import getLogDetailsUseCase from '../../../../../app/usecase/workout/GetLogDetailsUseCase';
import { GetLogDetailsContext } from '../GetLogDetailsContext';

export default function GetLogDetailsProvider(props: PropsWithChildren) {
  const useCase = new getLogDetailsUseCase(
    new WorkoutLogClientImpl(),
    new WorkoutLogResponseMapper()
  );

  return (
    <GetLogDetailsContext.Provider value={useCase}>
      {props.children}
    </GetLogDetailsContext.Provider>
  );
}
