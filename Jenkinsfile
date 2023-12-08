pipeline {
    agent any
    
    stages {
        
        stage('Checkout') {
            steps {
                git url: 'https://github.com/SusyLira/ClockTime.git'
            }
        }
        
        stage('Build') {
            steps {
                echo 'Building...'
            }
        }
    
        stage('Run Snyk Open Source Scan') {
          steps {
            echo 'Testing...'
            snykSecurity(
              snykInstallation: 'snykplugin',
              snykTokenId: 'snyktoken',
              failOnIssues: true,
              monitorProjectOnBuild: true,
              additionalArguments: '--all -projects --d'
                )
            }
        }
    
        stage('Run Snyk Code Scan') {
            steps {
                snykSecurity(
                    snykInstallation: 'snykplugin',
                    snykTokenId: 'snyktoken',
                    failOnIssues: true,
                    monitorProjectOnBuild: false,
                    additionalArguments: '--code -debug'
                )
            }
        }
    
        stage('Run Snyk IaC Scan') {
            steps {
                snykSecurity(
                    snykInstallation: 'snykplugin',
                    snykTokenId: 'snyktoken',
                    failOnIssues: true,
                    monitorProjectOnBuild: true,
                    additionalArguments: '--iac --report -d'
                )
            }
        }
    
        stage('Deploy') {
          steps {
            echo 'Deploying...'
          }
        }
    }
}
