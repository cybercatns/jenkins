pipeline {
    agent any

    stages {
        stage('Stage 01 - Code Quality') {
            steps {
                echo 'Download code from the repository and check for quality, vulnerabilities and compliance.'
            }
        }

        stage('Stage 02 - Compile and Build the Code') {
            steps {
                echo 'Some complex software need to be compiled and build to create application binaries. '
            }
        }
        
        stage('Stage 03 - Unit & Integration testing') {
            steps {
                echo 'Run the unit test cases automated by the developers.'
            }
        }
        
        stage('Stage 04 - Upload to Artifactory') {
            steps {
                echo 'Upload to Artifactory'
            }
        }         
    }

    post {
        // Clean after build
        always {
            cleanWs()
        }
    }
}