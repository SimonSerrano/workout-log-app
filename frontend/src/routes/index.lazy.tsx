import { createLazyFileRoute } from '@tanstack/react-router';
import Home from '../app/shared/external/react/page/Home';

export const Route = createLazyFileRoute('/')({
  component: Home,
});
