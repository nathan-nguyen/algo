#!/bin/bash
User=$1
Page=$2

for (( i = 1; i <= $Page; i++ ))
do
  URL=http://codeforces.com/submissions/$User/page/$i
  LOG=${i}.log
  echo "URL: ${URL} - Log: ${LOG}"
  curl $URL > $LOG
done

rm ${User}.problemlist
cat *.log | grep problem/ | sed 's/            <a href="//g' | sed 's/\">//g' | sort -u | tee -a ${User}.problemlist
rm *.log

