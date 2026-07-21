@echo off
REM Run script for Agenda API

echo Starting Agenda API...

REM Check if JAR file exists
if not exist target\agenda-api.jar (
    echo JAR file not found. Please build the application first using build.bat
    exit /b 1
)

REM Run the application
java -jar target\agenda-api.jar