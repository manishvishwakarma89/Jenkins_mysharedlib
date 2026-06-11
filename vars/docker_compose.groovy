def call(String composeFile){
    sh """
        docker compose -f ${composeFile} down
        docker compose -f ${composeFile} up -d
    """
}
