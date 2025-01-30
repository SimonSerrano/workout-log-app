import { createLazyFileRoute } from '@tanstack/react-router';
import WorkoutLogDetailsPage 
  from '../../../adapter/in/page/log/WorkoutLogDetailsPage';
import GetLogDetailsProvider from '../../../app/context/GetLogDetailsProvider';

export const Route = createLazyFileRoute('/log/$logId/')({
  component: () => (
    <GetLogDetailsProvider>
      <WorkoutLogDetailsPage />
    </GetLogDetailsProvider>
  ),
});
