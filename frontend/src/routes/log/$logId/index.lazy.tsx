import { createLazyFileRoute } from '@tanstack/react-router';
import WorkoutLogDetailsPage 
  from '../../../app/workout/external/react/page/WorkoutLogDetailsPage';
import {TrainedExerciseControllerProvider} 
  from '../../../app/trainedexercise';
import {ExerciseControllerProvider} from '../../../app/exercise';

export const Route = createLazyFileRoute('/log/$logId/')({
  component: () => (
    <TrainedExerciseControllerProvider>
      <ExerciseControllerProvider>
        <WorkoutLogDetailsPage />
      </ExerciseControllerProvider>
    </TrainedExerciseControllerProvider>
  ),
});
