Feature: Re-built jenkins jobs for failed scripts in aubdfrci folder

Scenario: re-built new framework suite

When Launch new framework suit in jenkins with defined user
And re-trigger new framework failed scripts with same tabs

Scenario: re-built afa suite

When Launch afa suite in jenkins with defined user
And re-trigger afa failed scripts with same tabs

