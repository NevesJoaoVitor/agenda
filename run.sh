#!/bin/bash
# Run script for Agenda API

echo "Starting Agenda API..."

# Check if JAR file exists
if [ ! -f "target/agenda-api.jar" ]; then
    echo "JAR file not found. Please build the application first using ./build.sh"
    exit 1
fi

# Run the application
java -jar target/agenda-api.jar