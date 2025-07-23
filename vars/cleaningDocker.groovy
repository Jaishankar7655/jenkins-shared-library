def call(String cleanCode) {
    echo "🧹 Cleaning: ${cleanCode}"
    sh 'docker compose down --volumes --remove-orphans'
}
