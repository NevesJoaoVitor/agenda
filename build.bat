@echo off
REM Build script for Agenda API

echo Building Agenda API...

REM Create target directory if it doesn't exist
if not exist target mkdir target

REM Compile Java source files
echo Compiling Java sources...
javac -d target\classes -sourcepath src\main\java src\main\java\com\mangati\agenda\*.java src\main\java\com\mangati\agenda\*\*.java src\main\java\com\mangati\agenda\*\*\*.java

REM Copy resources
echo Copying resources...
xcopy /E /I src\main\resources target\classes

REM Create jar file
echo Creating JAR file...
cd target\classes
jar -cf ..\agenda-api.jar *
cd ..\..

echo Build completed! The JAR file is available at target\agenda-api.jar
echo To run: java -jar target\agenda-api.jar