import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import './index.css';
import { routeTree } from './routeTree.gen';
import { createRouter, RouterProvider } from '@tanstack/react-router';
import { ThemeProvider, createTheme } from '@mui/material/styles';
import { CssBaseline } from '@mui/material';

const theme = createTheme({
  colorSchemes: {
    dark: true,
  },
  palette: {
    primary: {
      main: '#f4c428',
    },
    secondary: {
      main: '#f27a11',
    },
  },
});

const router = createRouter({ routeTree, });

declare module '@tanstack/react-router' {
  interface Register {
    router: typeof router;
  }
}

const rootElement = document.getElementById('root')!;
if (!rootElement.innerHTML) {
  const root = createRoot(rootElement);
  root.render(
    <StrictMode>
      <ThemeProvider theme={theme}>
        <CssBaseline/>
        <RouterProvider router={router} />
      </ThemeProvider>
    </StrictMode>
  );
}
