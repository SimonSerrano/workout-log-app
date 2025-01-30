import { createRootRoute } from '@tanstack/react-router';
import Home from '../adapter/in/page/Home';

export const Route = createRootRoute({
  component: Home,
});
