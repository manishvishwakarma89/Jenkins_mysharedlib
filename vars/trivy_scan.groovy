def call(String exitCode = "0", String severity = "HIGH,CRITICAL"){
    sh """
        trivy fs \
          --format table \
          --severity ${severity} \
          --exit-code ${exitCode} \
          --no-progress \
          --skip-dirs node_modules \
          --skip-dirs frontend/node_modules \
          --skip-dirs backend/node_modules \
          -o trivy-fs-report.txt \
          .
    """
    sh "cat trivy-fs-report.txt"
    archiveArtifacts artifacts: 'trivy-fs-report.txt', allowEmptyArchive: true
}
