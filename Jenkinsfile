#!groovy

node {
  // Need to replace the '%2F' used by Jenkins to deal with / in the path (e.g. story/...) because tests that do getResource will escape the % again, and the test files can't be found.
  
  ws("workspace/${env.JOB_NAME}/${env.BRANCH_NAME}".replace('%2F', '_')) {
	 
    // Mark the code checkout 'stage'.............
    stage 'Checkout'
	
    checkout scm
    
    // Mark the code build 'stage'....
    stage 'Build'
	 
   
 //   def  mvnHome = tool 'M2_HOME'
	  def  mvnHome = tool 'Maven'
 //  bat(/"${mvnHome}\bin\mvn" clean package/)
    sh "'${mvnHome}/bin/mvn' clean package"
     //sh 'cp /root/.jenkins/workspace/SampleMultibranch/master/master/target/PilotProject-0.war /usr/local/tomcat7/webapps/'
     sh 'cp /root/.jenkins/workspace/SampleMultibranch/${env.JOB_NAME}/${env.BRANCH_NAME}/target/PilotProject-0.war /usr/local/tomcat7/webapps/'
  }
	// ..
	build 'Test1MB' 
}
