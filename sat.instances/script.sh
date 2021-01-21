#!/bin/bash

for n in 20 23 24 43 60 100
do
    echo 3 $n
    timeout "$1s" minisat "3-$n.cnf" "3-$n.cnf.out" >"3-$n.cnf.result"
done

for n in 60 66 67 100
do
    echo 4 $n
    timeout "$1s" minisat "4-$n.cnf" "4-$n.cnf.out" >"4-$n.cnf.result"
done

for n in 140 150 160 170 171
do
    echo 5 $n
    timeout "$1s" minisat "5-$n.cnf" "5-$n.cnf.out" >"5-$n.cnf.result"
done
