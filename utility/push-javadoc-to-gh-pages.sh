#!/bin/bash

echo -e "Executing javadoc-to-gh-pages.sh\n"
echo -e "$TRAVIS_REPO_SLUG\n"
echo -e "$TRAVIS_BRANCH\n"

if [ "$TRAVIS_REPO_SLUG" == "RenegadeWizard/Building-Info" ] && [ "$TRAVIS_BRANCH" == "master" ]; then

  echo -e "Publishing javadoc...\n"

  cp -R target/site/apidocs $HOME/javadoc-latest

  cd $HOME
  git config --global user.email "travis@travis-ci.org"
  git config --global user.name "travis-ci"
  git clone -b gh-pages "https://github.com/${TRAVIS_REPO_SLUG}.git" gh-pages

  cd gh-pages
  git rm -rf ./javadoc
  cp -Rf $HOME/javadoc-latest ./javadoc
  git add -f .
  git commit -m "Latest javadoc on successful travis build $TRAVIS_BUILD_NUMBER auto-pushed to gh-pages"
  git push -fq "https://${GH_TOKEN}@github.com/${TRAVIS_REPO_SLUG}.git"

  echo -e "Published Javadoc to gh-pages.\n"
fi
