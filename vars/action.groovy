def call(String stageName){
  
  if ("${stageName}" == "Build")
     {
       sh "mvn clean package"
     }
  else if ("${stageName}" == "SonarQube Report")
     {
       sh "mvn clean sonar:sonar"
     }
  else if ("${stageName}" == "Upload Into Nexus")
     {
       sh "mvn deploy"
     }
  else if ("${stageName}" == "Deploy To Tomcat")
  {
    deploy adapters: [tomcat9(credentialsId: 'TomcatCredentials', path: '', url: 'http://172.31.10.30:8080/')], contextPath: null, onFailure: false, war: 'target/*war'
  }
}
