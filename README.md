# Package Downloader CLI

The Package Downloader (PD) CLI allows users to download the required applications based on their project and role. This document provides detailed usage instructions for the CLI.

## Table of Contents
1. [Usage](#usage)
2. [Options](#options)
3. [Examples](#examples)

## Usage
pd [-dhlV] [-dv] [-qa] [-qm] -p=\<project\>

## Options

- `-d, --download`: Download packages.
- `-dv, --developer`: Filter by developer.
- `-h, --help`: Show this help message and exit.
- `-l, --list`: List all available packages.
- `-p, --project=<project>`: Code of the project [mry = Mercury, vns = Venus, mrs = Mars]. This is a required option.
- `-qa, --automation-tester`: Filter by automation tester.
- `-qm, --manual-tester`: Filter by manual tester.
- `-V, --version`: Print version information and exit.

## Examples

### List All Packages for a Project
To list all the applications required for the Mercury project:

```sh
pd -l -p mry
```
### List Packages for a Manual Tester in a Project
To list all the applications required for a manual tester in the Mercury project:

```sh
pd -l -p mry -qm
```

### Download Packages for a Manual Tester in a Project
To download all the applications required for a manual tester in the Mercury project:

```sh
pd -p mry -qm -d
```

### List Packages for a Developer in a Project
To list all the applications required for a developer in the Mercury project:

```sh
pd -l -p mry -dv
```

### Download Packages for an Automation Tester in a Project
To download all the applications required for an automation tester in the Mercury project:

```sh
pd -p mry -qa -d
```

### Additional Information
For further assistance, use the help command:

```sh
pd -h
```

For version information:

```sh
pd -V
```

## Running the CLI
To run the CLI, do a Gradle build:

```sh
gradle build
```

In the IDE terminal, enter the following command followed by a `pd` command. For example, to list all the applications required for the Mercury project:

```sh
java -jar build/libs/package-downloader-cli-1.0.jar -l -p mry
```

### Alternative Method: Using a Batch File
1. After the Gradle build, copy the jar file from build/libs and paste it into a folder (e.g., PackageDownloader) in your system.

2. Create a pd.bat file in that folder and paste the below code:
```sh
@echo off

set JAR_PATH=./package-downloader-cli-1.0.jar
java -jar "%JAR_PATH%" %*
```

3. Now open CMD in that location and start running `pd` commands. For example, to list all the applications required for the Mercury project:
```sh
pd -l -p mry
```
