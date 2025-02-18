import { createLazyFileRoute } from '@tanstack/react-router';
import WorkoutLogDetailsPage 
  from '../../../external/ui/page/log/WorkoutLogDetailsPage';
import GetLogDetailsProvider 
  from '../../../external/ui/context/workout/GetLogDetailsProvider';
import DeleteWorkoutLogProvider 
  from '../../../external/ui/context/workout/DeleteWorkoutLogProvider';
import ListTrainedExercisesProvider 
  from '../../../external/ui/context/ListTrainedExercisesProvider';
import CreateTrainedExerciseProvider 
  from '../../../external/ui/context/CreateTrainedExerciseProvider';
import ListExercisesProvider 
  from '../../../external/ui/context/ListExercisesProvider';
import UpdateTrainedExerciseProvider 
  from '../../../external/ui/context/UpdateTrainedExerciseProvider';

export const Route = createLazyFileRoute('/log/$logId/')({
  component: () => (
    <GetLogDetailsProvider>
      <DeleteWorkoutLogProvider>
        <ListTrainedExercisesProvider>
          <CreateTrainedExerciseProvider>
            <ListExercisesProvider>
              <UpdateTrainedExerciseProvider>
                <WorkoutLogDetailsPage />
              </UpdateTrainedExerciseProvider>
            </ListExercisesProvider>
          </CreateTrainedExerciseProvider>
        </ListTrainedExercisesProvider>
      </DeleteWorkoutLogProvider>
    </GetLogDetailsProvider>
  ),
});
