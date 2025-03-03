#!/bin/bash

set -e

docker-compose --env-file .env up db backend --watch --build &
cd frontend && npm run dev -- --port 3000 &

wait