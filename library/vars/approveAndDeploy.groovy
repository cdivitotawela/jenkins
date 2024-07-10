#!/usr/bin/env groovy

def call(String dockerImageToDeploy) {

  stage('Waiting Approval') {
    timeout(time: 1, unit: 'DAYS') {
      input message: "Is it OK to deploy ${dockerImageToDeploy}?", ok: 'Deploy'
    }
  } 
} 