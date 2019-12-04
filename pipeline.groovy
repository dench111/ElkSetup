pipeline {
  agent {
    node {
      label " "
    }
  }
  stages {
    stage("Start Ansible Playbook from Git") {
      steps {
        script {
          def workspace = WORKSPACE
          sh "chmod ugo+rwx WORKSPACE"
          sh "ansible-playbook -i " + "inventory" + " " + workspace + "/" AnsiblePlaybook.yml"
        }
      }
    }
  }
}
