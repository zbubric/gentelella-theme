description "Installs scaffolding templates  that use f:all to render properties", "grails install-templates"
updateStatus """ 
WARNING: Script will overwrite and/or create files within your application!!!

Following files and folders will be created or overwritten (if exists):
    - Scaffolding templates: 
        src/main/templates/scaffolding/*
    - Static View Files:
        grails-app/views/error.gsp
        grails-app/views/index.gsp
        grails-app/views/notFound.gsp
    - gentelella layout files
        grails-app/views/layouts/gentelella/*

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
    
}

// Copy gentelella theme files
updateStatus "Copying gentelella theme files"
mkdir "grails-app/views/layouts/gentelella"
copy {
    from resources("gentelella/layouts/gentelella/*.gsp")
    into "grails-app/views/layouts/gentelella"
}    

// Replace common static views with Gentelella version
updateStatus "Copying customised static views"
copy {
    from resources("/gentelella/staticViews/*.gsp")
    into "grails-app/views"
}


// Replace original templates with gentelella-customised ones
updateStatus "Copying gentelella scaffolding templates"
mkdir "src/main/templates/scaffolding"
copy {
	from templates("scaffolding/*.gsp")
	into "src/main/templates/scaffolding"
}
copy {
	from templates("scaffolding/*.groovy")
	into "src/main/templates/scaffolding"
}

addStatus "Gentelella theme installation complete"
