@echo off

if "%1" == "" (java -jar pdf-assembly-1.0.jar *.pdf) else java -jar pdf-assembly-1.0.jar %*

PAUSE
