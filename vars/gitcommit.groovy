#!/usr/bin/env groovy

def call(String dockerImage){
    echo "commiting changes from jenkins into gitHub"
    withCredentials([usernamePassword(credentialsId: 'github_creds', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'git config --global user.email "jenkins@example.com"'
        sh 'git config --global user.name "jenkins"'
        def encodedPassword = URLEncoder.encode("$PASS",'UTF-8')
        sh "git remote set-url origin https://${USER}:${encodedPassword}@github.com/mmehdizadeh7777/MavenBuild.git"

        sh 'git add .'
        sh 'git commit -m "jenkins: version bump"'
        sh 'git push origin HEAD:jenkins-jobs'

    }

}