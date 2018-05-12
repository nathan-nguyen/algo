#!/bin/sh

tc=$2
rs=$3

if [ $tc == $rs ]
then
  echo "\033[0;32mTrue\033[0m"
else
  echo "\033[0;31mFalse\033[0m"
  echo "Input: $1"
  echo "Your result: $2"
  echo "Expected rsult: $3"
fi

exit 0
