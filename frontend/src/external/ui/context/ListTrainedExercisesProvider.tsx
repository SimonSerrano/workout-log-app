import { PropsWithChildren } from 'react';
import { ListTrainedExercisesContext } from './ListTrainedExercisesContext';
import ListTrainedExercisesUseCase 
  from '../../../app/usecase/ListTrainedExercisesUseCase';
import TrainedExerciseClientImpl from '../../web/TrainedExerciseClientImpl';
import TrainedExerciseResponseMapper 
  from '../../../app/port/out/mapper/TrainedExerciseResponseMapper';

export default function ListTrainedExercisesProvider(props: PropsWithChildren) {
  const useCase = new ListTrainedExercisesUseCase(
    new TrainedExerciseClientImpl(),
    new TrainedExerciseResponseMapper()
  );

  return (
    <ListTrainedExercisesContext.Provider value={useCase}>
      {props.children}
    </ListTrainedExercisesContext.Provider>
  );
}
