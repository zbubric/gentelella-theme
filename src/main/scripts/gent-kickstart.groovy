description "Installs scaffolding templates  that use f:all to render properties", "grails install-templates"
updateStatus """ 
WARNING: Script will overwrite and/or create files within your application!!!

Following files and folders will be created or overwritten (if exists):
    - gentelella layout files
        grails-app/views/layouts/gentelella.gsp
    - Static View Files:
        grails-app/views/index.gsp
        grails-app/views/login.gsp
        grails-app/views/error.gsp
        grails-app/views/notFound.gsp
        grails-app/views/forbidden.gsp
        grails-app/views/plainPage.gsp    
    - gentelella menu config file
        grails-app/conf/menuConf.json        
    - Scaffolding templates: 
        src/main/templates/scaffolding/*

It is recomended to backup your files before runing the script!

"""

// get user confirmation
def console = System.console()
def confirmation
if (console) {
    confirmation = console.readLine('> Do you wish to continue? (y/n): ')    
    if( !confirmation.equalsIgnoreCase('Y') ){
        updateStatus "Script aborted. Bye-bye..."
        return
    }    
} else {
    updateStatus "Cannot get console. Leaving script..."
    return   
}

// Copy gentelella theme files
updateStatus "Copying gentelella theme files"
copy {
    from resources("/gentelella/layouts/*.gsp")
    into "grails-app/views/layouts"
}

// Copy gentelella menu config
updateStatus "Copying gentelella menu config"
copy {
    from resources("/gentelella/conf/*.json")
    into "/grails-app/conf"
}    

// Replace common static views with Gentelella version
updateStatus "Copying customized static views"
copy {
    from resources("/gentelella/static-views/*.gsp")
    into "grails-app/views"
}

// Replace original templates with gentelella-customised ones
updateStatus "Copying gentelella scaffolding templates"
mkdir "src/main/templates/scaffolding"
copy {
    from resources("/gentelella/scaffolding/*.*")
    into "/src/main/templates/scaffolding"
}


addStatus "Gentelella theme installation complete"
