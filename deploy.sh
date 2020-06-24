#!/bin/bash
#
#  ssh + scp without storing or prompting for keys.
#
tar -zcvf webserver.tar.gz .
chmod 400 id_rsa
scp -i id_rsa -o "ConnectTimeout 3" \
        -o "StrictHostKeyChecking no" \
        -o "UserKnownHostsFile /dev/null" \
        "$@" webserver.tar.gz ubuntu@18.217.87.1:/home/ubuntu

#Here you extract your archive on EC2 using SSH
echo "Start deploy"
ssh -i id_rsa -o "ConnectTimeout 3" \
        -o "StrictHostKeyChecking no" \
        -o "UserKnownHostsFile /dev/null" \
            "$@" ubuntu@18.217.87.1  'tar -xvzf webserver.tar.gz | java -jar target/webserver-1.0.jar'
echo "Deploy end"