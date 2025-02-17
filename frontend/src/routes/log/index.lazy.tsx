import { createLazyFileRoute } from '@tanstack/react-router';
import WorkoutLogPage from '../../external/ui/page/log/WorkoutLogPage';
import ListWorkoutLogsProvider from '../../external/ui/context/ListWorkoutLogsProvider';
import CreateWorkoutLogProvider 
  from '../../external/ui/context/CreateWorkoutLogProvider';

export const Route = createLazyFileRoute('/log/')({
  component: () => (
    <ListWorkoutLogsProvider>
      <CreateWorkoutLogProvider>
        <WorkoutLogPage />
      </CreateWorkoutLogProvider>
    </ListWorkoutLogsProvider>
  ),
});
