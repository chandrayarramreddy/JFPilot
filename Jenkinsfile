#!groovy

node {
  // Need to replace the '%2F' used by Jenkins to deal with / in the path (e.g. story/...) because tests that do getResource will escape the % again, and the test files can't be found.
  
  ws("workspace/${env.JOB_NAME}/${env.BRANCH_NAME}".replace('%2F', '_')) {
    // Mark the code checkout 'stage'....
    stage 'Checkout'
	{
    checkout scm
    }
    // Mark the code build 'stage'....
    stage 'Build'
    {
    def  mvnHome = tool 'M2_HOME'
   bat(/"${mvnHome}\bin\mvn" clean package/)
    }
  }
}
