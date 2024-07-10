import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()

// Set up a new security realm (user database)
def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount('admin', 'adminPassword')
instance.setSecurityRealm(hudsonRealm)

// Set up authorization strategy (role-based access control)
def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
strategy.setAllowAnonymousRead(false)
instance.setAuthorizationStrategy(strategy)

// Save the current Jenkins state to disk
instance.save()

println '=== init.groovy.d === Created admin user with username admin'