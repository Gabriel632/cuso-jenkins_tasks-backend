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
        // não implementado por não conseguir rodar docker do sonar
        /*
        stage ('Quality Gate') {
            steps {  
                sleep(5) 
                timeout(time: 1, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true         
                }                            
            }
        }
        */
        stage ('Deploy Backend') {
            steps {  
                deploy adapters: [tomcat8(credentialsId: 'tomcat_login', path: '', url: 'http://localhost:8001')], contextPath: 'tasks-backend', war: 'target/tasks-backend.war'                        
            }
        }
        stage ('API Test') {
            steps {  
                dir('api-test') {
                    git credentialsId: 'github_login', url: 'https://github.com/Gabriel632/curso-jenkins_tests-api-tasks'     
                    bat '"C:\\Repositorio\\apache-maven-3.9.4\\bin\\mvn.cmd" test'   
                }                               
            }
        }
        stage ('Deploy Frontend') {
            steps {  
                dir('frontend') {
                    git credentialsId: 'github_login', url: 'https://github.com/Gabriel632/curso-jenkins_tasks-frontend'
                    bat '"C:\\Repositorio\\apache-maven-3.9.4\\bin\\mvn.cmd" clean package'
                    deploy adapters: [tomcat8(credentialsId: 'tomcat_login', path: '', url: 'http://localhost:8001')], contextPath: 'tasks', war: 'target/tasks.war'
                }                                        
            }
        }
        stage ('Functional Test') {
            steps {  
                dir('functional-test') {
                    git branch: 'main', credentialsId: 'github_login', url: 'https://github.com/Gabriel632/curso-jenkins_tests-functional-tasks'     
                    bat '"C:\\Repositorio\\apache-maven-3.9.4\\bin\\mvn.cmd" test'   
                }                               
            }
        }
        stage ('Deploy Prod') {
            steps {
                bat 'docker-compose build'
                bat 'docker-compose up -d'
            }
        }
        stage ('Health Check') {
            steps {  
                sleep(5)
                dir('functional-test') {                    
                    bat '"C:\\Repositorio\\apache-maven-3.9.4\\bin\\mvn.cmd" verify -Dskip.surefire.tests'   
                }                               
            }
        }
    }
}