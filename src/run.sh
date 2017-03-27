#!/bin/sh

javac -classpath .:../libs/* cs473/*.java
java -classpath .:../libs/* cs473.Main pluvi.us ../files/simpleData.csv
