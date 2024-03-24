pipeline {
    agent any
    stages {
        stage ('Build Backend') {
            steps {               
                bat 'set M2_HOME=C:\Users\gabri\OneDrive\Área de Trabalho\Programas\apache-maven-3.9.4'
                bat 'set path=C:\Users\gabri\OneDrive\Área de Trabalho\Programas\apache-maven-3.9.4\bin;%path%'
                bat 'mvn clean'
            }
        }
    }
}