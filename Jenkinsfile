pipeline {
    agent any
    stages {
        stage ('Build Backend') {
            steps {               
                bat '"C:\\Repositorio\\apache-maven-3.9.4\\bin\\mvn.cmd" --version'
                bat '"C:\\Repositorio\\apache-maven-3.9.4\\bin\\mvn.cmd" clean package -DskipTests=true'
            }
        }
        stage ('Unit Tests') {
            steps {               
                bat '"C:\\Repositorio\\apache-maven-3.9.4\\bin\\mvn.cmd" test'
            }
        }
    }
}