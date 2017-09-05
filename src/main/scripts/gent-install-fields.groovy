description "Installs scaffolding templates  that use f:all to render properties", "grails install-templates"
updateStatus """ 
WARNING: Script will overwrite and/or create files within your application!!!

Following files and folders will be created or overwritten (if exists):
    - Custom fields rendering definitions
        grails-app/views/layouts/_fields/*        
    - Custom table/list rendering templates
        grails-app/views/layouts/templates/*                

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
      
// list of custom fields folder
def folderList = ['boolean', 'date', 'default', 'oneToMany', 'radioGroup'] 

// copy content of each folder
folderList.each{ name ->
    mkdir "grails-app/views/_fields/$name"
    copy {
        from resources("/gentelella/fields/$name/*.gsp")
        into "grails-app/views/_fields/$name"
    }
}   

// copy definition of list and table templates
mkdir "grails-app/views/templates/_fields/"
copy {
    from resources("gentelella/fields/templates/_fields/*.gsp")
    into "grails-app/views/templates/_fields"
}

addStatus "Gentelella theme installation complete"
