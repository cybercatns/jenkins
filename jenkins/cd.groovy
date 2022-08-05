pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                cleanWs()
                sh "pwd && ls -ltrh"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                sh "cd terraform && \
                terraform init && \
                terraform apply -auto-approve"
            }
        }

        stage('Install') {
            steps {
                sh "cp terraform/inventory ansible/"
                sh "cd ansible && \
                ansible-playbook -i inventory webservers.yaml"
            }
        }
    }
}