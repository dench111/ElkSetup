pipeline {
  agent {
    node {
      label " "
    }
  }
  stages {
    stage("Install Java & Check Java version") {
      steps {
        script {
          def workspace = "/var/lib/jenkins/workspace/Ansible_Git"
          sh "chmod ugo+rwx $workspace/*"
          sh "ansible -m setup servers"
          sh "ansible-playbook -i " + "inventory" + " " + "$workspace/java-install-pb.yml"
      }
    }
  }
 }
}
