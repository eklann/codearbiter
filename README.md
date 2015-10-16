# codearbiter
A server for judging code, for example for code golf and programming competitions.

## Intro
CodeArbiter is a server that judges code. You can set up your own problems, and define input-output pairs that a solution to the problem is expected to produce. You communicate with the server over HTTP.

## Language support
None, so far :( Java will probably be the first one to be supported. Should be easy to add new languages.

## Modes
None, as of now :( Code-Golf will probably be the first usable mode.

## Dependencies 
To run codearbiter you must have docker, and some database supported by hibernate to store the data in the instance (problems, users, solutions, etc.).