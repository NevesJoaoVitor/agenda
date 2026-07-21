#!/bin/bash
# Build script for Agenda API

echo "Building Agenda API..."

# Create target directory if it doesn't exist
mkdir -p target

# Compile Java source files
echo "Compiling Java sources..."
javac -d target/classes -sourcepath src/main/java src/main/java/com/mangati/agenda/*.java src/main/java/com/mangati/agenda/*/*.java src/main/java/com/mangati/agenda/*/*/*.java

# Copy resources
echo "Copying resources..."
cp -r src/main/resources/* target/classes/

# Create jar file
echo "Creating JAR file..."
cd target/classes
jar -cf ../agenda-api.jar *
cd ../..

echo "Build completed! The JAR file is available at target/agenda-api.jar"
echo "To run: java -jar target/agenda-api.jar"