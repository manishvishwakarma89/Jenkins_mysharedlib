def call(String exitCode = "0", String severity = "HIGH,CRITICAL"){
    sh """
        trivy fs \
          --format table \
          --severity ${severity} \
          --exit-code ${exitCode} \
          --no-progress \
          -o trivy-fs-report.txt \
          .
        
        echo "Trivy scan completed"
        cat trivy-fs-report.txt
    """
    
    archiveArtifacts artifacts: 'trivy-fs-report.txt', allowEmptyArchive: true
}
