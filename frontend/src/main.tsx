import { StrictMode, useMemo } from 'react';
import { createRoot } from 'react-dom/client';
import './index.css';
import { routeTree } from './routeTree.gen';
import { createRouter, RouterProvider } from '@tanstack/react-router';
import { 
  ThemeProvider, 
  createTheme } from '@mui/material/styles';
import { CssBaseline, useMediaQuery } from '@mui/material';






const router = createRouter({ routeTree, });

declare module '@tanstack/react-router' {
  interface Register {
    router: typeof router;
  }
}


// eslint-disable-next-line react-refresh/only-export-components
function App() {

  const prefersDarkMode = useMediaQuery('(prefers-color-scheme: dark)');

  const theme = useMemo(() => {
    return createTheme({
      palette: {
        mode: prefersDarkMode ? 'dark': 'light',
        primary: {
          main: '#f4c428',
        },
        secondary: {
          main: '#fbe751',
        },
      },
    }); 
  }, [prefersDarkMode,]);

  return <ThemeProvider theme={theme}>
    <CssBaseline/>
    <RouterProvider router={router} />
  </ThemeProvider>;
}

const rootElement = document.getElementById('root')!;
if (!rootElement.innerHTML) {
  const root = createRoot(rootElement);
  root.render(
    <StrictMode>
      <App/>
    </StrictMode>
  );
}
