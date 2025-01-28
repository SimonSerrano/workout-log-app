import { createLazyFileRoute } from '@tanstack/react-router'
import Home from '../page/Home'

export const Route = createLazyFileRoute('/')({
  component: Home,
})
