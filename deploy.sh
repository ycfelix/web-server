#!/bin/bash

tar -zcvf webserver.tar.gz .
scp webserver.tar.gz ubuntu@18.217.87.1:/home/ubuntu

#Here you extract your archive on EC2 using SSH
echo "Start deploy"
yes yes | ssh -i id_rsa ubuntu@18.217.87.1 tar -xvzf webserver.tar.gz && java -jar target/webserver-1.0.jar
echo "Deploy end"