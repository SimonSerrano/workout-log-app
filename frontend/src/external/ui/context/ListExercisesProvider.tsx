import { PropsWithChildren } from 'react';
import ListExercisesUseCase from '../../../app/usecase/ListExercisesUseCase';
import { ListExercisesContext } from './ListExercisesContext';
import ExerciseClientImpl from '../../web/ExerciseClientImpl';
import ExerciseReponseMapper 
  from '../../../app/port/out/mapper/ExerciseResponseMapper';

export default function 
ListExercisesProvider(props: PropsWithChildren) {
  const useCase = new ListExercisesUseCase(
    new ExerciseClientImpl(),
    new ExerciseReponseMapper()
  );

  return (
    <ListExercisesContext.Provider value={useCase}>
      {props.children}
    </ListExercisesContext.Provider>
  );
}