import { PropsWithChildren } from 'react';
import TrainedExerciseResponseMapper 
  from '../../../app/port/out/mapper/TrainedExerciseResponseMapper';
import CreateTrainedExerciseUseCase 
  from '../../../app/usecase/CreateTrainedExerciseUseCase';
import TrainedExerciseClientImpl from '../../web/TrainedExerciseClientImpl';
import { CreateTrainedExerciseContext } from './CreateTrainedExerciseContext';

export default function 
CreateTrainedExerciseProvider(props: PropsWithChildren) {
  const useCase = new CreateTrainedExerciseUseCase(
    new TrainedExerciseClientImpl(),
    new TrainedExerciseResponseMapper()
  );

  return (
    <CreateTrainedExerciseContext.Provider value={useCase}>
      {props.children}
    </CreateTrainedExerciseContext.Provider>
  );
}