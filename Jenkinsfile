pipeline {
    agent any
    
    stages {
        
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: 'SusyLira-patch-1']], userRemoteConfigs: [[url: 'https://github.com/SusyLira/ClockTime.git']]])
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
            dir('/var/lib/jenkins/workspace/Snykp') {
            snykSecurity(
              snykInstallation: 'snykplugin',
              snykTokenId: 'snyktoken',
              failOnIssues: true,
              monitorProjectOnBuild: true,
              additionalArguments: '--file=ClockTime.java'
                )
            }
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
