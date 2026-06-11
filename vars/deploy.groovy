def call(){
    sh """
        mkdir -p /home/ubuntu/wanderlust
        cp docker-compose.yml /home/ubuntu/wanderlust/
        cp backend/.env.docker /home/ubuntu/wanderlust/backend.env
        cp frontend/.env.docker /home/ubuntu/wanderlust/frontend.env
        cd /home/ubuntu/wanderlust
        docker compose down || true
        docker compose up -d
    """
}
