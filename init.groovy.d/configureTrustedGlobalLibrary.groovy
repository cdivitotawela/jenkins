import jenkins.model.*
import hudson.plugins.git.*
import jenkins.plugins.git.*

// Define the shared library configuration
def libraryConfig = new org.jenkinsci.plugins.workflow.libs.LibraryConfiguration(
    'library',
    new org.jenkinsci.plugins.workflow.libs.SCMSourceRetriever(
        new GitSCMSource(
            null,  // ID, not needed
            'https://github.com/cdivitotawela/jenkins.git',
            '',  // Credentials ID, if needed
            '*',  // Includes, default is '*'
            '',  // Excludes, default is ''
            false  // Ignore on push notifications
        )
    )
)

// Set the default version for the library
libraryConfig.defaultVersion = 'main'
libraryConfig.implicit = false  // Set to true if you want this library to be available implicitly
libraryConfig.allowVersionOverride = true  // Allow version override in Jenkinsfiles

// Get the Jenkins instance and update the global library configuration
def instance = Jenkins.getInstance()
def globalLibraries = instance.getDescriptorByType(org.jenkinsci.plugins.workflow.libs.GlobalLibraries.class)
globalLibraries.libraries.add(libraryConfig)
instance.save()

println '=== init.groovy.d === Configured shared library with id library'