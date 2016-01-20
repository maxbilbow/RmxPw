#!/bin/bash

appRootDir=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )

timestamp=$(date +"%Y-%m-%d_%H-%M-%S")

java -DappRootDir=$appRootDir -Dtimestamp=$timestamp -jar lib/${project.artifactId}-${project.version}.jar
