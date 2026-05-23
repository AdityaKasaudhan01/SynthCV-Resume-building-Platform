@REM ----------------------------------------------------------------------------
@REM Licensed to the Apache Software Foundation (ASF) under one
@REM or more contributor license agreements. See the NOTICE file
@REM distributed with this work for additional information
@REM regarding copyright ownership. The ASF licenses this file
@REM to you under the Apache License, Version 2.0 (the
@REM "License"); you may not use this file except in compliance
@REM with the License. You may obtain a copy of the License at
@REM
@REM http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing,
@REM software distributed under the License is distributed on an
@REM "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
@REM KIND, either express or implied. See the License for the
@REM specific language governing permissions and limitations
@REM under the License.
@REM ----------------------------------------------------------------------------

@REM ----------------------------------------------------------------------------
@REM Apache Maven Wrapper startup batch script
@REM ----------------------------------------------------------------------------

@IF "%__MVNW_ARG0_NAME__%"=="" (SET "BASE_DIR=%~dp0") ELSE (SET "BASE_DIR=%__MVNW_ARG0_NAME__%")

@SET MAVEN_PROJECTBASEDIR=%BASE_DIR%
@SET MAVEN_WRAPPER_JAR="%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.jar"
@SET MAVEN_WRAPPER_PROPERTIES="%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.properties"
@SET DOWNLOAD_URL="https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar"

@FOR /F "usebackq tokens=1,2 delims==" %%A IN (%MAVEN_WRAPPER_PROPERTIES%) DO (
    @IF "%%A"=="wrapperUrl" SET DOWNLOAD_URL=%%B
)

@IF EXIST %MAVEN_WRAPPER_JAR% (
    @SET MVNW_VERBOSE=false
    @IF "%MVNW_VERBOSE%"=="true" (
        @ECHO "Found %MAVEN_WRAPPER_JAR%"
    )
) ELSE (
    @ECHO "Downloading Maven Wrapper..."
    @IF "%MVNW_REPOURL%"=="" (
        @SET MVNW_REPOURL=https://repo.maven.apache.org/maven2
    )
    @powershell -Command "&{"^
        "$webclient = new-object System.Net.WebClient;"^
        "if (-not ([string]::IsNullOrEmpty('%MVNW_USERNAME%') -and [string]::IsNullOrEmpty('%MVNW_PASSWORD%'))) {"^
        "$webclient.Credentials = new-object System.Net.NetworkCredential('%MVNW_USERNAME%', '%MVNW_PASSWORD%');"^
        "}"^
        "[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12; $webclient.DownloadFile('%DOWNLOAD_URL%', '%MAVEN_WRAPPER_JAR%')"^
        "}"
    @IF "%ERRORLEVEL%"=="0" (@ECHO "Downloaded Maven Wrapper successfully.") ELSE (
        @ECHO "Failed to download Maven Wrapper. Please download it manually."
        @EXIT /B 1
    )
)

@SET JAVA_HOME_CANDIDATE=%JAVA_HOME%
@IF "%JAVA_HOME_CANDIDATE%"=="" (
    @ECHO "JAVA_HOME is not set. Please set JAVA_HOME to your JDK installation."
    @EXIT /B 1
)

@SET JAVA_EXE="%JAVA_HOME_CANDIDATE%\bin\java.exe"
@IF NOT EXIST %JAVA_EXE% (
    @ECHO "Java executable not found at %JAVA_EXE%"
    @EXIT /B 1
)

@SET WRAPPER_LAUNCHER=org.apache.maven.wrapper.MavenWrapperMain
@SET WRAPPER_URL="https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar"

%JAVA_EXE% ^
  -classpath %MAVEN_WRAPPER_JAR% ^
  "-Dmaven.multiModuleProjectDirectory=%MAVEN_PROJECTBASEDIR%" ^
  %WRAPPER_LAUNCHER% %MAVEN_CONFIG% %*
