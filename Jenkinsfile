pipeline {
    agent {label 'jenkins-agent'}

    tools {
        // Configure a JDK and Maven installation with these names
        // in Manage Jenkins -> Tools, or remove this block if using a configured agent.
        jdk 'java21'
        maven 'maven3'
    }

    stages {
        stage('Cleanup Workspace') {
            steps {
                cleanWs()
            }
        }

        stage('Checkout from SCM') {
            steps {
                git branch: 'main', credentialsId: 'github', url: 'https://github.com/Rohit9-bit/Basic-java-application'
            }
        }

        stage('Build Application') {
            steps {
                sh "mvn clean package"
            }
        }

        stage("Test Application") {
            steps {
                sh "mvn test"
            }
        }

        stage("SonarQube Analysis") {
            steps {
                script {
                    withSonarQubeEnv(credentialsId: 'jenkins-sonarqube-token') {
                        sh "mvn sonar:sonar"
                    }
                }
            }
        }

        stage("Quality Gate"){
            steps {
                script {
                    waitForQualityGate abortPipeline: false, credentialsId: 'jenkins-sonarqube-token'
                }
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
