pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps { echo 'Code checked out' }
        }
        stage('Build with Maven') {
            steps { sh 'mvn clean package' }
        }
    }
    post {
        success { echo '✅ Build completed successfully!' }
        failure { echo '❌ Build failed! Check logs.' }
    }
}
