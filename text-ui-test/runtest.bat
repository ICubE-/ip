@ECHO OFF

REM create bin directory if it doesn't exist
if not exist ..\bin mkdir ..\bin

REM delete output from previous run
if exist ACTUAL.TXT del ACTUAL.TXT

if exist data\nuke.txt del data\nuke.txt

REM compile the code into the bin folder
javac  -cp ..\src\main\java -Xlint:none -d ..\bin ..\src\main\java\nuke\*.java
javac  -cp ..\src\main\java -Xlint:none -d ..\bin ..\src\main\java\nuke\command\*.java
javac  -cp ..\src\main\java -Xlint:none -d ..\bin ..\src\main\java\nuke\command\exception\*.java
javac  -cp ..\src\main\java -Xlint:none -d ..\bin ..\src\main\java\nuke\task\*.java
IF ERRORLEVEL 1 (
    echo ********** BUILD FAILURE **********
    exit /b 1
)
REM no error here, errorlevel == 0

REM run the program, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath ..\bin nuke.Nuke < input.txt > ACTUAL.TXT

REM compare the output to the expected output
FC ACTUAL.TXT EXPECTED.TXT
