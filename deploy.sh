#!/bin/bash

echo "Start deploy"
cd ~/circleci-aws
git pull
java -jar target/webserver-1.0.jar
echo "Deploy end"