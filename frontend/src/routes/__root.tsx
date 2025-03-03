import { createRootRoute } from '@tanstack/react-router';
import Home from '../app/shared/external/react/page/Home';

export const Route = createRootRoute({
  component: Home,
});
