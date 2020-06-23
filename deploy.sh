#!/bin/bash

tar -zcvf webserver.tar.gz .
scp webserver.tar.gz ubuntu@18.217.87.1:/home/ubuntu

#Here you extract your archive on EC2 using SSH
ssh ubuntu@18.217.87.1 tar -xvzf webserver.tar.gz
echo "Start deploy"
java -jar target/webserver-1.0.jar
echo "Deploy end"