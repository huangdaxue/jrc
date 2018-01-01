#/bin/bash

spring_config_location="-Dspring.config.location=config/jdbc.properties,jrc-web-server/config/application.yml"

java $spring_config_location -jar xx.jar