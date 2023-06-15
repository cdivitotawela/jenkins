pipeline {

  agent any

  stages {
    stage('Checkout'){
      steps {
        checkout scmGit(
          branches: [
              [name: '**']
          ],
          extensions: [
              cloneOption(depth: 1,
              noTags: false,
              reference: '',
              shallow: true)
          ],
          userRemoteConfigs: [
              [
                  credentialsId: 'GitHub',
                  url: 'https://github.com/cdivitotawela/jenkins'
              ]
          ]
        )
      }
    }
  }
}