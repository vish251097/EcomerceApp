pipeline {
    agent any

    tools {
        jdk 'JDK25'
        maven 'Maven_3.9.11'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/vish251097/EcomerceApp.git',
                    credentialsId: 'github-token'
            }
        }

        stage('Build with Maven') {
            steps {
                sh '/usr/local/bin/mvn clean package'
            }
        }
    }

    post {
        success {
            echo '✅ Build completed successfully!'
        }
        failure {
            echo '❌ Build failed. Check logs.'
        }
    }
}
