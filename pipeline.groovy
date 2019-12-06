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
          sh "ansible -m setup servers > $workspace/Ansible_env_variables.txt"
          sh "ansible-playbook -i " + "inventory" + " " + "$workspace/Elastic_Nodes-install-pb.yml"
      }
    }
  }
 }
}
