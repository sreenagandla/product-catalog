pipeline {
         agent any
         tools {
                   gradle 'Gradle5'
         }
 
 	stages {
    		stage('Build') 	{
			steps {
        			sh './gradlew -b build.gradle build'
			}
    		}
    		stage('parallel stages') {
    		        parallel {
    			        stage('Archival') {
				        steps {
        				        archiveArtifacts 'build/libs/*.jar'
				        }
    			        }
		
			        stage('Test cases') {
				        steps {
        				        junit 'build/test-results/test/*.xml'
				        }
    		      }

		   } 
  }

  	}
}
