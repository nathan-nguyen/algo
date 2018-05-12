#!/bin/bash
User=$1

for number in {1..146}
do
  URL=http://codeforces.com/submissions/$User/page/$number
  LOG=${number}.log
  echo "URL: ${URL} - Log: ${LOG}"
  curl $URL > $LOG
done

