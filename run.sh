#!/bin/bash

set -e

cd backend && ./mvnw spring-boot:run &
cd frontend && npm run dev &

wait