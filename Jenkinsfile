pipeline {

  agent any

  triggers {
    when{ branch 'main' }
    cron('* * * * *')
  }

  stages {
    stage('Test'){
      steps {
        echo "Test"
      }
    }
  }
}