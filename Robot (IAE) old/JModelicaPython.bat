@echo off
call C:\JModelica.org-2.4\setenv.bat 64
if %errorlevel% neq 0 pause
"%PYTHONHOME%\python.exe" %*
if %errorlevel% neq 0 pause
