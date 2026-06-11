// Define function
def call(String imageName, String tag){
    sh """
        docker build -t ${imageName}-backend:${tag} ./backend
        docker build -t ${imageName}-frontend:${tag} ./frontend
    """
}
