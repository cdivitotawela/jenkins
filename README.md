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

4. Navigate to Jenkins console http://localhost:8080

