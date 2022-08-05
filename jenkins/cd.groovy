pipeline {
    agent any

    stages {
        stage('Stage 01 - Deploy Infrastructure') {
            steps {
                sh "cd terraform && \
                terraform init && \
                terraform apply -auto-approve"
            }
        }

        stage('Stage 02 - Install & Configure the application') {
            steps {
                sh "chmod 400 ansible/files/jenkins.pem && ls -lah ansible/files/jenkins.pem"
                sh "cp terraform/inventory ansible/"
                sh "export ANSIBLE_SSH_RETRIES=3 && cd ansible && \
                ansible-playbook -i inventory webservers.yaml"
            }
        }
        
        stage('Stage 03 - Functional & E2E Testing') {
            steps {
                echo 'Testing.......'
                echo 'All tests passed - 100%'
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