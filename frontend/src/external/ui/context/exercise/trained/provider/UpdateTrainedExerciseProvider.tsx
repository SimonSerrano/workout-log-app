import { PropsWithChildren } from 'react';
import TrainedExerciseResponseMapper 
  from '../../../../../../app/port/out/mapper/TrainedExerciseResponseMapper';

import TrainedExerciseClientImpl from '../../../../../web/TrainedExerciseClientImpl';
import UpdateTrainedExerciseUseCase 
  from '../../../../../../app/usecase/exercise/UpdateTrainedExerciseUseCase';
import { UpdateTrainedExerciseContext } from '../UpdateTrainedExerciseContext';

export default function 
UpdateTrainedExerciseProvider(props: PropsWithChildren) {
  const useCase = new UpdateTrainedExerciseUseCase(
    new TrainedExerciseClientImpl(),
    new TrainedExerciseResponseMapper()
  );

  return (
    <UpdateTrainedExerciseContext.Provider value={useCase}>
      {props.children}
    </UpdateTrainedExerciseContext.Provider>
  );
}