Payment Application Monitor Widget
===================================

SonarQube Payment Application Monitor Widget gathers and displays information related to PCI DSS.

Introduction
------------

Payment application Monitor widget shows all the non compliencies related to PCI DSS

To install this plug-in, follow these steps:

A) Create the plug-in binary with this command:

    mvn clean package

B) Copy the file to your SonarQube installation:

    copy target/padss-widget-1.0.jar $SONARQUBE_HOME/extensions/plugins

C) Restart SonarQube

D) Add the widget to a dashboard

E) Analyse a project and enjoy!
