import { createLazyFileRoute } from '@tanstack/react-router'
import WorkoutLogPage from '../../adapter/in/page/log/WorkoutLogPage'
import ListWorkoutLogsProvider from '../../app/context/ListWorkoutLogsProvider'


export const Route = createLazyFileRoute('/log/')({
  component: () => (
    <ListWorkoutLogsProvider>
      <WorkoutLogPage />
    </ListWorkoutLogsProvider>
  ),
})
