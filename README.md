# Jenkins
This repository contains docker based Jenkins setup for quick learning and experiments.

1. Clone the repository
   `git clone https://github.com/cdivitotawela/jenkins`

2. Start the Jenkins. This will build the Jenkins container with plug-ins and start
   ```shell
   docker-compose up -d --build
   ```
3. Jenkins console url http://localhost:8080
4. Admin user `admin/adminPassword` is created as part of the init scripts

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

## Configuration

Jenkins is configured at startup using the groovy scripts in the [init.groovy.d](./init.groovy.d) folder. These scripts are
mounted to the /usr/share/jenkins/ref/init.groovy.d of the Jenkins container which are executed when the 
/usr/share/jenkins/jenkins.sh script runs at start. 

| Script                                 | Purpose                                                     |
|----------------------------------------|-------------------------------------------------------------|
| `createAdminUser.groovy`               | Creating admin user for the Jenkins                         |
| `configureTrustedGlobalLibrary.groovy` | Configure trusted global libary pointing to this repository | 

Also Jenkins system properties can be controlled by setting environment variable `JENKINS_JAVA_OPTS`. There are number of 
parameters which can be used to control the system. These are documented at https://www.jenkins.io/doc/book/managing/system-properties/ System parameter `-Djenkins.install.runSetupWizard=false` is used to disable the setup wizard during
initial start.