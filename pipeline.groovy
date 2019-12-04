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
          def playbookName = AnsiblePlaybook.yml
          def workspace = WORKSPACE
          sh "chmod ugo+rwx WORKSPACE"
          sh "ansible-playbook -i " + "inventory" + " " + workspace + "/" + playbookName
        }
      }
    }
  }
}
