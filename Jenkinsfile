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
        // não implementado por não conseguir rodar docker do sonar
        /*
        stage ('Sonar Analysis') {
            environment {
                scannerHome = tool 'SONAR_SCANNER'
            }
            steps {   
                withSonarQubeEnv('SONAR_LOCAL') {
                    bat "${scannerHome}/bin/sonar-scanner -e -Dsonar..." //passados vários parametros usando o -D
                }                     
            }
        }
        */
    }
}