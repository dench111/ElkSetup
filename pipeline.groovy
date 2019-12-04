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
          def playbookName = "AnsiblePlaybook.yml"
          def workspace = "/var/lib/jenkins/workspace/Ansible_Git"
          sh "chmod ugo+rwx $workspace/*"
          sh "ansible-playbook -i " + "inventory" + " " + "$workspace/AnsiblePlaybook.yml
      }
    }
  }
}
