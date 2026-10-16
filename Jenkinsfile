pipeline {
    agent any

    tools {
        // Configure a JDK and Maven installation with these names
        // in Manage Jenkins -> Tools, or remove this block if using a configured agent.
        jdk 'JDK17'
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn -B clean package'
            }
        }

        stage('Archive WAR') {
            steps {
                archiveArtifacts artifacts: 'target/*.war', fingerprint: true
            }
        }
    }

    post {
        success {
            echo 'Build succeeded. The WAR artifact has been archived.'
        }
        failure {
            echo 'Build failed. Review the console output for details.'
        }
    }
}
