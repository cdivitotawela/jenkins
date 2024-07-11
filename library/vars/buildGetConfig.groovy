// getConfigFromClosure
def call(Closure body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    echo 'Build Config: ' + config
    return config
}