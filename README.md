# Jenkins
This repository contains docker based Jenkins setup for quick learning and experiments.

1. Clone the repository
   `git clone https://github.com/cdivitotawela/jenkins`

2. Start the Jenkins. This will build the Jenkins container with plug-ins and start
   ```shell
   docker-compose up -d --build
   ```
3. If this is the first time starting Jenkins, retrieve the initial password
   ```shell
   
   docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
   ```

4. Jenkins console url http://localhost:8080

## Periodic Trigger Multi-Branch Pipeline
It is possible to trigger multi-branch pipeline periodically for specific branch. 
```groovy
pipeline {
  agent any
  triggers {
    // Build periodically for main branch
    cron(env.BRANCH_NAME == 'main' ? '* * * * *' : '')
  }

  stages {
    stage('Message'){
      steps {
        echo "Trigger every minute"
      }
    }
  }
}
```