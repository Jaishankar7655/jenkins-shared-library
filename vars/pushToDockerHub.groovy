def call(String imageName, String tag = "latest") {
    withCredentials([usernamePassword(
        credentialsId: 'dockerHubCred',
        usernameVariable: 'DOCKER_HUB_USER',
        passwordVariable: 'DOCKER_HUB_PASS'
    )]) {
        echo 'Logging into Docker Hub...'
        sh """
            docker login -u "$DOCKER_HUB_USER" -p "$DOCKER_HUB_PASS"
        """

        echo "Tagging the image as \$DOCKER_HUB_USER/${imageName}:${tag}"
        sh """
            docker tag django-app-django:latest \$DOCKER_HUB_USER/${imageName}:${tag}
        """

        echo "Pushing the image to Docker Hub..."
        sh """
            docker push \$DOCKER_HUB_USER/${imageName}:${tag}
        """
    }
}
