import { createLazyFileRoute } from '@tanstack/react-router';
import WorkoutControllerProvider 
  from '../../app/workout/external/react/context/WorkoutControllerProvider';
import WorkoutLogPage 
  from '../../app/workout/external/react/page/WorkoutLogPage';

export const Route = createLazyFileRoute('/log/')({
  component: () => (
    <WorkoutControllerProvider>
      <WorkoutLogPage />
    </WorkoutControllerProvider>
  ),
});
