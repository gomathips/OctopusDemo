## Installation
# General
    Java SDK 1.8

# For Mac:
	brew install maven
	or
	Download Maven Archive from https://maven.apache.org/download.cgi and extract the Maven archive and
	copy to any path and also set the environment path as below


    export MAVEN_HOME=<maven extracted path>
    export PATH=$MAVEN_HOME:$PATH


# For Ubuntu
    sudo apt install maven
    or
    Download Maven Archive from https://maven.apache.org/download.cgi and extract the Maven archive and
    copy to any path and also set the environment path as below

    export MAVEN_HOME=<maven extracted path>
    export PATH=$MAVEN_HOME:$PATH


# For Windows:
    Download Maven Archive from https://maven.apache.org/download.cgi and extract the Maven archive and
    copy to any path and also set the environment path as below

    set MAVEN_HOME=<maven extracted path>
    set path=%path%;%MAVEN_HOME%\bin


## To run the tests from command line
```
mvn clean install
mvn test
```

# About Chrome driver path and version
    Chrome version 88 already exist in the project path src/main/resources/drivers for Windows and Mac
    Update the version and os type in config file if you have a different chrome version
    which can be download it from https://chromedriver.chromium.org/downloads
    Follow below driver naming convention to avoid exception
    For Mac and other OS
        chromedriver-{OS-Type}-{chromeversion}
    For Windows
        chromedriver-{OS-Type}-{chromeversion}.exe