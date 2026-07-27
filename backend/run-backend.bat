@echo off
cd /d D:\SynthCV\backend
set MAVEN_PROJECTBASEDIR=D:\SynthCV\backend
java -Dmaven.multiModuleProjectDirectory="D:\SynthCV\backend" -cp ".mvn\wrapper\maven-wrapper.jar" org.apache.maven.wrapper.MavenWrapperMain spring-boot:run