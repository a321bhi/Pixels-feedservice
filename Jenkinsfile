pipeline {
  agent any
  stages {
    stage('Initialize') {
      steps {
        echo 'Initializing'
        bat 'mvn clean'
      }
    }

    stage('Build') {
      steps {
        bat 'mvn package -Dmaven.test.skip'
      }
    }

    stage('Static Analysis') {
      steps {
        bat 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar'
      }
    }

    stage('Deploy') {
      steps {
        bat 'docker build -t pixels-feedservice .'
        bat 'docker tag pixels-feedservice abhi2104/pixels-feedservice:latest'
        bat 'docker push abhi2104/pixels-feedservice:latest'
      }
    }

    stage('') {
      agent {
      	label 'jenkinsagent'
      }
      steps {
        sh 'docker pull abhi2104/pixels-feedservice:latest'
      }
    }

  }
}