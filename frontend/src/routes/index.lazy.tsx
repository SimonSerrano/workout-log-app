import { createLazyFileRoute } from '@tanstack/react-router';
import Home from '../external/ui/page/Home';

export const Route = createLazyFileRoute('/')({
  component: Home,
});
