def call(){
  dependencyCheck additionalArguments: '''
        --scan .
        --format XML
        --format HTML
        --out .
        --prettyPrint
    ''', odcInstallation: 'OWASP'
    
    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
  
}
