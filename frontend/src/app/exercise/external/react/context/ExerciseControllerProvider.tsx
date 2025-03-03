import { PropsWithChildren } from 'react';
import ListExercisesUseCaseImpl from 
  '../../../usecase/impl/ListExercisesUseCaseImpl';
import { ExerciseControllerContext } from './ExerciseControllerContext';
import ExerciseControllerImpl 
  from '../../../adapter/impl/ExerciseControllerImpl';
import ExerciseClientGatewayImpl 
  from '../../web/impl/ExerciseClientGatewayImpl';
import ExerciseClientImpl from '../../web/impl/ExerciseClientImpl';


const controller = new ExerciseControllerImpl(
  new ListExercisesUseCaseImpl(
    new ExerciseClientGatewayImpl(
      new ExerciseClientImpl()
    )
  )
);

export default function 
ExerciseControllerProvider(props: PropsWithChildren) {
  return (
    <ExerciseControllerContext.Provider value={controller}>
      {props.children}
    </ExerciseControllerContext.Provider>
  );
}