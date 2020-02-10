pipelineJob('Build_Ramdisk_PipelineOnGithub') {
  description('This job runs pipeline that builds Ironic ramdisk with ironic-python-agent using diskimage-builder')

  parameters {
    stringParam('DIB_DISTRIBUTION', 'ubuntu', 'Distribution element')
    stringParam('DIB_RELEASE', 'bionic', 'Distribution release')
    stringParam('DIB_REPOREF_ironic_python_agent', 'origin/stable/queens', '')
    stringParam('EXTRA_ELEMENTS', '', 'Space separated list of other elements')
  }

  logRotator {
    numToKeep(20)
  }

  definition {
    cpsScm {
      lightweight(true)
      scm {
        git {
          remote {
            url('https://github.com/kozhukalov/ramdisk-building-pipeline')
          }
          branch('master')
        }
      }
      scriptPath('pipeline.groovy')
    }
  }

}
