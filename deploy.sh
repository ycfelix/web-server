#!/bin/bash
#
#  ssh + scp without storing or prompting for keys.
#
function sshtmp
{
    ssh -o "ConnectTimeout 3" \
        -o "StrictHostKeyChecking no" \
        -o "UserKnownHostsFile /dev/null" \
            "$@"
}
function scptmp
{
    exec scp -o "ConnectTimeout 3" \
        -o "StrictHostKeyChecking no" \
        -o "UserKnownHostsFile /dev/null" \
        "$@"
}
tar -zcvf webserver.tar.gz .
chmod 400 id_rsa
scptmp -i id_rsa webserver.tar.gz ubuntu@18.217.87.1:/home/ubuntu

#Here you extract your archive on EC2 using SSH
echo "Start deploy"
sshtmp -i id_rsa ubuntu@18.217.87.1 
tar -xvzf webserver.tar.gz
java -jar target/webserver-1.0.jar
echo "Deploy end"