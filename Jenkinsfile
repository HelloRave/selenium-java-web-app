def NOTIFY_USERS = 'hello@gmail.com'

pipeline {
    agent any

    tools {
        maven 'maven 3.9.8'
        jdk 'OpenJDK17'
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '1'))
        disableConcurrentBuilds(abortPrevious: true)
    }

    parameters {
        string(name: 'EMAIL_LIST', defaultValue: "${NOTIFY_USERS}", description: 'Email notifications to')
    }

    stages {
        stage('Clean') {
            steps {
                sh '''
                    echo "Start clean"
                    mvn clean
                '''
            }
        }

        stage('Test') {
            steps {
                sh '''
                    echo "Start test"
                    mvn install
                '''
            }
        }
    }

    post {
        failure {
            mail to: "${params.EMAIL_LIST}",
                subject: "${env.JOB_NAME} - Build #${env.BUILD_NUMBER} Failed!",
                body: """
                    <p>Check console output at <a href="${env.BUILD_URL}">here</a> to view the results.</p>
                """,
                mimeType: 'text/html'
        }

        success {
            mail to: "${params.EMAIL_LIST}",
                subject: "${env.JOB_NAME} - Build #${env.BUILD_NUMBER} Succeeded!",
                body: """
                    <p>Check console output at <a href="${env.BUILD_URL}">here</a> to view the results.</p>
                """,
                mimeType: 'text/html'
        }
    }
}