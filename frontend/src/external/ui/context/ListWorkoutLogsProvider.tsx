import { PropsWithChildren } from 'react';
import { ListWorkoutLogsContext } from './ListWorkoutLogsContext';
import ListWorkoutLogsUseCase from '../../../app/usecase/ListWorkoutLogsUseCase';
import WorkoutLogClientImpl from '../../web/WorkoutLogClientImpl';
import WorkoutLogResponseMapper 
  from '../../../app/port/out/mapper/WorkoutLogResponseMapper';

export default function ListWorkoutLogsProvider(props: PropsWithChildren) {
  const useCase = new ListWorkoutLogsUseCase(
    new WorkoutLogClientImpl(),
    new WorkoutLogResponseMapper()
  );

  return (
    <ListWorkoutLogsContext.Provider value={useCase}>
      {props.children}
    </ListWorkoutLogsContext.Provider>
  );
}
