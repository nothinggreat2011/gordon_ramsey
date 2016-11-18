#!/usr/bin/env bash
mvn clean install
java -jar target/demo-gordon-ramsey-1.0-SNAPSHOT.jar run_data/data.txt
