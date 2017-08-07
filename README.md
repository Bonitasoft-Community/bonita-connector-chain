# bonita-connector-chain
Set of connectors for Chain

## Pre-requisite

These connectors have been implemented for Bonita CE 7.2.4. The most recent versions of Bonita should be compatible with this set of connectors, but there is no guarantee. 

This project rely on the bonita-connectors project. Install this project locally: https://github.com/bonitasoft/bonita-connectors

## Build the connectors 

Run the command:
```    
mvn package
```

The zip version of the built connectors can be find under <connector_name_folder>/<connector_name>-impl/target/<connector_name>-impl-1.0-connector.zip

By example, for the connector chain-issue-asset, the zip version will be located under chain-issue-asset/chain-issue-asset-impl/target/chain-issue-asset-impl-1.0-connector.zip

## Import the connectors

To import the connector in your Studio:

* Open the Bonita Studio
* Go to Development -> Connectors -> Import connector
* In the invite window, select a zip version of the built connector

** Important: Never try to open the implementation of an imported connector in the Studio, it will result by overriding the imported implementation by an empty one.**
