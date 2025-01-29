/* eslint-disable */

// @ts-nocheck

// noinspection JSUnusedGlobalSymbols

// This file was automatically generated by TanStack Router.
// You should NOT make any changes in this file as it will be overwritten.
// Additionally, you should also exclude this file from your linter and/or formatter to prevent it from being checked or modified.

import { createFileRoute } from '@tanstack/react-router'

// Import Routes

import { Route as rootRoute } from './routes/__root'

// Create Virtual Routes

const IndexLazyImport = createFileRoute('/')()
const LogIndexLazyImport = createFileRoute('/log/')()
const LogLogIdIndexLazyImport = createFileRoute('/log/$logId/')()

// Create/Update Routes

const IndexLazyRoute = IndexLazyImport.update({
  id: '/',
  path: '/',
  getParentRoute: () => rootRoute,
} as any).lazy(() => import('./routes/index.lazy').then((d) => d.Route))

const LogIndexLazyRoute = LogIndexLazyImport.update({
  id: '/log/',
  path: '/log/',
  getParentRoute: () => rootRoute,
} as any).lazy(() => import('./routes/log/index.lazy').then((d) => d.Route))

const LogLogIdIndexLazyRoute = LogLogIdIndexLazyImport.update({
  id: '/log/$logId/',
  path: '/log/$logId/',
  getParentRoute: () => rootRoute,
} as any).lazy(() =>
  import('./routes/log/$logId/index.lazy').then((d) => d.Route),
)

// Populate the FileRoutesByPath interface

declare module '@tanstack/react-router' {
  interface FileRoutesByPath {
    '/': {
      id: '/'
      path: '/'
      fullPath: '/'
      preLoaderRoute: typeof IndexLazyImport
      parentRoute: typeof rootRoute
    }
    '/log/': {
      id: '/log/'
      path: '/log'
      fullPath: '/log'
      preLoaderRoute: typeof LogIndexLazyImport
      parentRoute: typeof rootRoute
    }
    '/log/$logId/': {
      id: '/log/$logId/'
      path: '/log/$logId'
      fullPath: '/log/$logId'
      preLoaderRoute: typeof LogLogIdIndexLazyImport
      parentRoute: typeof rootRoute
    }
  }
}

// Create and export the route tree

export interface FileRoutesByFullPath {
  '/': typeof IndexLazyRoute
  '/log': typeof LogIndexLazyRoute
  '/log/$logId': typeof LogLogIdIndexLazyRoute
}

export interface FileRoutesByTo {
  '/': typeof IndexLazyRoute
  '/log': typeof LogIndexLazyRoute
  '/log/$logId': typeof LogLogIdIndexLazyRoute
}

export interface FileRoutesById {
  __root__: typeof rootRoute
  '/': typeof IndexLazyRoute
  '/log/': typeof LogIndexLazyRoute
  '/log/$logId/': typeof LogLogIdIndexLazyRoute
}

export interface FileRouteTypes {
  fileRoutesByFullPath: FileRoutesByFullPath
  fullPaths: '/' | '/log' | '/log/$logId'
  fileRoutesByTo: FileRoutesByTo
  to: '/' | '/log' | '/log/$logId'
  id: '__root__' | '/' | '/log/' | '/log/$logId/'
  fileRoutesById: FileRoutesById
}

export interface RootRouteChildren {
  IndexLazyRoute: typeof IndexLazyRoute
  LogIndexLazyRoute: typeof LogIndexLazyRoute
  LogLogIdIndexLazyRoute: typeof LogLogIdIndexLazyRoute
}

const rootRouteChildren: RootRouteChildren = {
  IndexLazyRoute: IndexLazyRoute,
  LogIndexLazyRoute: LogIndexLazyRoute,
  LogLogIdIndexLazyRoute: LogLogIdIndexLazyRoute,
}

export const routeTree = rootRoute
  ._addFileChildren(rootRouteChildren)
  ._addFileTypes<FileRouteTypes>()

/* ROUTE_MANIFEST_START
{
  "routes": {
    "__root__": {
      "filePath": "__root.tsx",
      "children": [
        "/",
        "/log/",
        "/log/$logId/"
      ]
    },
    "/": {
      "filePath": "index.lazy.tsx"
    },
    "/log/": {
      "filePath": "log/index.lazy.tsx"
    },
    "/log/$logId/": {
      "filePath": "log/$logId/index.lazy.tsx"
    }
  }
}
ROUTE_MANIFEST_END */
