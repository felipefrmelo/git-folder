#!/bin/bash
lein uberjar
cat stub.sh target/uberjar/git-folder-0.1.0-SNAPSHOT-standalone.jar > git-folder && chmod +x git-folder 
