@echo off

set MAVEN_HOME=C:\apache-maven-3.9.6
set PATH=%MAVEN_HOME%\bin;%PATH%

cd C:\eclipse\opencart

mvn test
