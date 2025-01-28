import { createLazyFileRoute } from '@tanstack/react-router'
import WorkoutLogPage from '../page/log/WorkoutLogPage'

export const Route = createLazyFileRoute('/log')({
  component: WorkoutLogPage,
})