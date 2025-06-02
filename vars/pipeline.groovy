pipeline {
    agent any

    environment {
        APP_NAME = 'my-npm-app'
        DOCKER_IMAGE = "my-npm-app:latest"
        APP_PORT = '3000'
    }

    triggers {
        pollSCM('* * * * *') // optional if not using webhook
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'git@github.com:yourusername/yourrepo.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t $DOCKER_IMAGE .'
                }
            }
        }

        stage('Stop Old Container') {
            steps {
                script {
                    sh '''
                    docker stop $APP_NAME || true
                    docker rm $APP_NAME || true
                    '''
                }
            }
        }

        stage('Run New Container') {
            steps {
                script {
                    sh '''
                    docker run -d --name $APP_NAME -p $APP_PORT:$APP_PORT $DOCKER_IMAGE
                    '''
                }
            }
        }
    }
}
