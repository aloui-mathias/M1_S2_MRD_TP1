#!/bin/bash

javac *.java

for n in 20 23 24 43 60 100
do
    java Main 3 $n
done

for n in 60 66 67 100
do
    java Main 4 $n
done

for n in 140 150 160 170 171
do
    java Main 5 $n
done

rm *.class