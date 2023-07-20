#!/bin/bash
set -xe


# Copy war file from S3 bucket to tomcat webapp folder
aws s3 cp s3://locomotive-webappdeploymentbucket-1rhj874tklg12/ResourceServerApplication.war /usr/local/tomcat9/webapps/ResourceServerApplication.war


# Ensure the ownership permissions are correct.
chown -R tomcat:tomcat /usr/local/tomcat9/webapps