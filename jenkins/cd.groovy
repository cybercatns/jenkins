pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'                
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
                sh "sudo chmod 400 ansible/files/jenkins.pem && ll ansible/files/jenkins.pem"
                sh "cp terraform/inventory ansible/"
                sh "cd ansible && \
                ansible-playbook -i inventory webservers.yaml"
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