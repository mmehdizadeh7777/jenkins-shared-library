#!/usr/bin/env groovy
environment {
    DOCKERHUB_CREDENTIALS = credentials('dockerhub')
}
def call(string dockerImage){
    echo "building and pushing the docker image"
    sh "docker build -t $dockerImage ."
    withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USER', passwordVariable: 'PASS')]) {    
    sh "echo $PASS | docker login -u $USER --password-stdin"
    //sh "docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW"
    }
    sh "docker push $dockerImage"
}
