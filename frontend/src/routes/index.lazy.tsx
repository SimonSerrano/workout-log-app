import { createLazyFileRoute } from '@tanstack/react-router'
import Home from '../adapter/in/page/Home'

export const Route = createLazyFileRoute('/')({
  component: Home,
})
