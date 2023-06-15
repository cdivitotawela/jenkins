pipeline {

  agent any

  triggers {
    // Build periodically for main branch
    cron(env.BRANCH_NAME == 'main' ? '* * * * *' : '')
  }

  stages {
    stage('Test'){
      steps {
        echo "Test"
      }
    }
  }
}