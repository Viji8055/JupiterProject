pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'My Name is Vijay'
            }
        }
         stage('Test') {
            steps {
                echo 'My Name is Aishwarya'
            }
        }
         stage('Deploy') {
            steps {
                echo 'We Love Eachother'
            }
        }
    }
    post
    {
        always
        {
            emailext body: 'message', subject: 'Pipeline', to: 'vijay.snigdha@gmail.com'
        }
    }
}
