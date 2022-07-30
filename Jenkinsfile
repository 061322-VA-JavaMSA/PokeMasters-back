pipeline {
    agent any
    environment {
        PORT_HOST = "8081"
        PORT_CONT = "8080"
        IMAGE_TAG = "pokemasters"
        CONTAINER_NAME = "pokemasters_container"
        DB_URL = credentials('DB_URL')
        DB_USER = credentials('DB_USER')
        DB_PASS = credentials('DB_PASS')
    }
    stages {
        stage('remove existing container') {
            steps {
                sh 'docker stop ${CONTAINER_NAME}'
            }
        }
        stage('remove existing image') {
            steps {
                sh 'docker rmi ${IMAGE_TAG}'
            }
        }
        stage('create image') {
            steps {
                sh 'docker build -t ${IMAGE_TAG} -f Dockerfile .'
            }
        }
        stage('create container') {
            steps {
                sh 'docker run -e DB_URL=${DB_URL} -e DB_USER=${DB_USER} -e DB_PASS=${DB_PASS} -d --rm -p ${PORT_HOST}:${PORT_CONT} --name ${CONTAINER_NAME} ${IMAGE_TAG}'
            }
        }
    }
}