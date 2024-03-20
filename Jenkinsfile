pipeline {
    agent any
    stages {
        stage ('Build Backend') {
            steps {
                bat '"C:\Users\gabri\OneDrive\Área de Trabalho\Programas\apache-maven-3.9.4\bin\mvn.cmd" mvn clean package -DskipTests=true'
            }
        }
    }
}