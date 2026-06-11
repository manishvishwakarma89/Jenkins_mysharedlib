def call(String project, String imageTag, String dockerHubUser){

    withCredentials([
        usernamePassword(
            credentialsId: 'dockerHubCreds',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )
    ]) {

        sh """
            docker login -u ${DOCKER_USER} -p ${DOCKER_PASS}
            docker push ${dockerHubUser}/${project}:${imageTag}
        """
    }
}
