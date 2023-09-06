pipeline {
    agent {
        maven 'maven_3_2_3'
    }
    stages {
        stage('Build') {
            stage('maven build'){
                steps {
                    checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/abhishekchaudhary-github/patientHUB']])
                    sh 'mvn clean install'
                }
            }
        }
        stage('test') {
            steps {
                // Run tests
            }
        }
        stage('docker image build') {
            steps {
                // Build a Docker image of your application
                sh 'docker build -t raebso/project-0.0.1-SNAPSHOT'
            }
        }
        stage('push image to docker hub') {
            steps {
                script {
                   withCredentials([string(credentialsId: 'pid', variable: 'password')]) {
                   // some block
                   sh 'docker login -u raebso -p ${password}'
                }
                    sh 'docker push raebso/project-0.0.1-SNAPSHOT'
                }
            }
        }
    }
}