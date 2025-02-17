import { createLazyFileRoute } from '@tanstack/react-router';
import WorkoutLogDetailsPage 
  from '../../../external/ui/page/log/WorkoutLogDetailsPage';
import GetLogDetailsProvider from '../../../app/context/GetLogDetailsProvider';

export const Route = createLazyFileRoute('/log/$logId/')({
  component: () => (
    <GetLogDetailsProvider>
      <WorkoutLogDetailsPage />
    </GetLogDetailsProvider>
  ),
});
