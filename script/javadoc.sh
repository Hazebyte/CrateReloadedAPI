#!/bin/bash

REPO_OWNER=Hazebyte
REPO=CrateReloadedAPI
APIDOCS=./target/site/apidocs
TMP=/tmp/cr/api
BRANCH=gh-pages

# Exit on any errors
set -e

# Create java docs
mvn javadoc:javadoc

# Create tmp to store docs
mkdir -p $TMP

# Move docs to tmp
mv $APIDOCS $TMP

# Remove everything that isn't in staging
rm -r *

# Update origin
git remote set-url origin https://"${TOKEN_OWNER}":"${TOKEN}"@github.com/${REPO_OWNER}/${REPO}.git

# Get branchs
git fetch origin $BRANCH
git checkout gh-pages

# Move docs into cwd
cp -R $TMP/apidocs/* .

# Add files
git add .
git commit -m "update javadocs"

# Push to git
git push origin gh-pages
