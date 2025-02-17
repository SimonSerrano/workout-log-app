import { createLazyFileRoute } from '@tanstack/react-router';
import WorkoutLogDetailsPage 
  from '../../../external/ui/page/log/WorkoutLogDetailsPage';
import GetLogDetailsProvider 
  from '../../../external/ui/context/GetLogDetailsProvider';
import DeleteWorkoutLogProvider 
  from '../../../external/ui/context/DeleteWorkoutLogProvider';

export const Route = createLazyFileRoute('/log/$logId/')({
  component: () => (
    <GetLogDetailsProvider>
      <DeleteWorkoutLogProvider>
        <WorkoutLogDetailsPage />
      </DeleteWorkoutLogProvider>
    </GetLogDetailsProvider>
  ),
});
