pipeline {
    agent any
    stages {
        stage ('Build Backend') {
            steps {
                bat '%MAVEN_HOME% mvn clean package -DskipTests=true'
            }
        }
    }
}