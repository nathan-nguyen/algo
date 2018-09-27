#!/bin/bash

cat words.txt | tr ' ' '\n' | sort | uniq -c

