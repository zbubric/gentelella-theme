package gentelella.theme

import grails.plugins.*

class gentelellaThemeGrailsPlugin extends Plugin {

    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "3.1.0 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
    ]

    
    def title = "Gentelella Theme" // Headline display name of the plugin
    def author = "Zoran Bubric"
    def authorEmail = "zbubric@gmail.com"
    def description = """Port of Gentelella theme for Grails 3.x Fw.
    Gentelella Admin is a Bootstrap3 based admin template packed with
    variety of powerful jQuery plugins and tools."""
    def profiles = ['web']

    // URL to the plugin's documentation
    def documentation = "https://github.com/zbubric/gentelella-theme"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "MIT"

    // Details of company behind the plugin (if there is one)
//    def organization = [ name: "My Company", url: "http://www.my-company.com/" ]

    // Any additional developers beyond the author specified above.
//    def developers = [ [ name: "Joe Bloggs", email: "joe@bloggs.net" ]]

    // Location of the plugin's issue tracker.
    def issueManagement = [ system: "Github Issues", url: "https://github.com/zbubric/gentelella-theme/issues" ]

    // Online location of the plugin's browseable source code.
    def scm = [ url: "https://github.com/zbubric/gentelella-theme" ]

    Closure doWithSpring() { {->
            // TODO Implement runtime spring config (optional)
        }
    }

    void doWithDynamicMethods() {
        // TODO Implement registering dynamic methods to classes (optional)
    }

    void doWithApplicationContext() {
        // TODO Implement post initialization spring config (optional)
    }

    void onChange(Map<String, Object> event) {
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    void onConfigChange(Map<String, Object> event) {
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }

    void onShutdown(Map<String, Object> event) {
        // TODO Implement code that is executed when the application shuts down (optional)
    }
}
