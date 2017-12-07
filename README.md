# Grails Gentelella theme plugin
[![Build Status](https://travis-ci.org/zbubric/gentelella-theme.svg?branch=master)](https://travis-ci.org/zbubric/gentelella-theme)

Port of [Gentelella theme](https://github.com/puikinsh/gentelella) for Grails 3.x Fw.

# Introduction

Gentelella theme plugin is a port of Gentelella theme for Grails 3.x framework. It provides adapted layout, fields rendering and scaffolding templates needed to style your Grails application with Gentelella theme.

While Original Gentelella provides full-featured admin template, Grails port integrate just most basic parts of it:

- Gentelella theme look & feel, including layout and styling
- Configurable menu
- Customised scaffolding for CRUD forms
- Set of additional form control widgets (DateTimePicker, Typeahead, Tag pillbox etc..)

# Installation

To add the Gentelella theme plugin to an application add the following dependency to the dependencies block of your `BuildConfig.groovy`:
`compile "org.grails.plugins:gentelella-theme:0.0.9"`


Run gent-kickstart script in order to copy all needed files to host project (__warning__ : some files can be overwritten):
`gent-kickstart`


UI layout and CRUD screens genrated after script execution will use the Gentelella theme styling!

To configure side menu, edit `/grails-app/conf/menuConf.json` file.

# Documentation (work ongoing)

For further information please see the full documentation (__warning__ : Documentation is still under construction and unstable).
Documentation can be found here ():

- [Stable](https://grails-fields-plugin.github.io/grails-fields/latest) version
- [Snapshot](https://grails-fields-plugin.github.io/grails-fields/snapshot) version

[Gentelella theme repo](https://github.com/puikinsh/gentelella)
