import { createLazyFileRoute } from '@tanstack/react-router'
import ListWorkoutLogsProvider from '../adapter/in/page/log/ListWorkoutLogsProvider'
import WorkoutLogPage from '../adapter/in/page/log/WorkoutLogPage'

export const Route = createLazyFileRoute('/log')({
  component: () => (
    <ListWorkoutLogsProvider>
      <WorkoutLogPage/>
    </ListWorkoutLogsProvider>
  ),
})