#!/bin/bash

set -e

echo "Installing backend dependencies"
cd backend && ./mvnw clean install && cd ..

echo "Installing frontend dependencies"
cd frontend && npm install


echo "Done installing project dependencies"