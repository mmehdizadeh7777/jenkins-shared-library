#!/usr/bin/env groovy
def call(){
    echo "building and pushing the docker image"
    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'PASS', usernameVariable: 'USER')])
    sh "docker build -t mmehdizadeh7777/maven-example:1.1 ."
    sh "echo $PASS | docker login -u $USER --password-stdin"
    sh "docker push mmehdizadeh7777/maven-example:1.1"
}