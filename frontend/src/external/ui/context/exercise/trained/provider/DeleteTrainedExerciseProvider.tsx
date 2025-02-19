import { PropsWithChildren } from 'react';
import DeleteTrainedExerciseUseCase 
  from '../../../../../../app/usecase/exercise/DeleteTrainedExerciseUseCase';
import TrainedExerciseClientImpl 
  from '../../../../../web/TrainedExerciseClientImpl';
import { DeleteTrainedExerciseContext } from '../DeleteTrainedExerciseContext';

export default 
function DeleteTrainedExercisesProvider(props: PropsWithChildren) {
  const useCase = new DeleteTrainedExerciseUseCase(
    new TrainedExerciseClientImpl()
  );

  return (
    <DeleteTrainedExerciseContext.Provider value={useCase}>
      {props.children}
    </DeleteTrainedExerciseContext.Provider>
  );
}