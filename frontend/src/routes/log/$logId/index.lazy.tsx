import { createLazyFileRoute } from '@tanstack/react-router';
import WorkoutLogDetailsPage 
  from '../../../external/ui/page/log/WorkoutLogDetailsPage';
import GetLogDetailsProvider 
  from '../../../external/ui/context/GetLogDetailsProvider';
import DeleteWorkoutLogProvider 
  from '../../../external/ui/context/DeleteWorkoutLogProvider';
import ListTrainedExercisesProvider 
  from '../../../external/ui/context/ListTrainedExercisesProvider';

export const Route = createLazyFileRoute('/log/$logId/')({
  component: () => (
    <GetLogDetailsProvider>
      <DeleteWorkoutLogProvider>
        <ListTrainedExercisesProvider>
          <WorkoutLogDetailsPage />
        </ListTrainedExercisesProvider>
      </DeleteWorkoutLogProvider>
    </GetLogDetailsProvider>
  ),
});
