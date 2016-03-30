#!/bin/bash cacls  *.*  /t  /e  /g  everyone:f  
set -e
for dir in */ ; do
  cd $dir
  mvn clean test
  cd ..
done