pipeline {
  agent any

  stages {
    stage('checkout') {
      options {
        timeout(time: 1, unit: 'MINUTES')
      }
      steps {
        git(url: 'https://github.com/henryStelle/maven-samples-A6', branch: 'master')
      }
    }

    stage('run') {
      options {
        timeout(time: 5, unit: 'MINUTES')
      }
      steps {
        sh 'mvn verify -q'
        sh 'mvn test -q'
        sh 'mvn clean'
      }
    }
  }

  post {
    failure {
      // fe4e6bf is the last known good commit (add A6 class)
      // the commit hash is different in your repository
      // as I was forced to update a dependency and rebase
      sh 'git bisect start HEAD fe4e6bf'
      sh 'git bisect run mvn clean test -q'
      sh 'git bisect reset'
    }
  }
}