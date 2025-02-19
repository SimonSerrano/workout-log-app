import { createLazyFileRoute } from '@tanstack/react-router';
import WorkoutLogDetailsPage 
  from '../../../external/ui/page/log/WorkoutLogDetailsPage';
import GetLogDetailsProvider 
  from '../../../external/ui/context/workout/provider/GetLogDetailsProvider';
import DeleteWorkoutLogProvider 
  from '../../../external/ui/context/workout/provider/DeleteWorkoutLogProvider';
import ListTrainedExercisesProvider 
  from 
  '../../../external/ui/context/exercise/trained/ListTrainedExercisesProvider';
import CreateTrainedExerciseProvider 
  from 
  '../../../external/ui/context/exercise/trained/CreateTrainedExerciseProvider';
import ListExercisesProvider 
  from '../../../external/ui/context/exercise/ListExercisesProvider';
import UpdateTrainedExerciseProvider 
  from 
  '../../../external/ui/context/exercise/trained/UpdateTrainedExerciseProvider';
import DeleteTrainedExercisesProvider 
  from 
  '../../../external/ui/context/exercise/trained/DeleteTrainedExerciseProvider';

export const Route = createLazyFileRoute('/log/$logId/')({
  component: () => (
    <GetLogDetailsProvider>
      <DeleteWorkoutLogProvider>
        <ListTrainedExercisesProvider>
          <CreateTrainedExerciseProvider>
            <ListExercisesProvider>
              <UpdateTrainedExerciseProvider>
                <DeleteTrainedExercisesProvider>
                  <WorkoutLogDetailsPage />
                </DeleteTrainedExercisesProvider>
              </UpdateTrainedExerciseProvider>
            </ListExercisesProvider>
          </CreateTrainedExerciseProvider>
        </ListTrainedExercisesProvider>
      </DeleteWorkoutLogProvider>
    </GetLogDetailsProvider>
  ),
});
