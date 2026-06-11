def call(String imageName, String tag, String dockerHubUser){
    sh """
        docker build -t ${dockerHubUser}/${imageName}-backend:${tag} ./backend
        docker build -t ${dockerHubUser}/${imageName}-frontend:${tag} ./frontend
    """
}
