#!/bin/bash
User=$1

for number in {1..23}
do
  URL=http://codeforces.com/submissions/$User/page/$number
  LOG=${number}.log
  echo "URL: ${URL} - Log: ${LOG}"
  curl $URL > $LOG
done

cat *.log | grep problem/ | sed s/'<a href=\"\/problemset\/problem\/'//g | sed s/'\">'//g | sed s/'\/'//g | sort | uniq | cut -c13-16 | grep [C-Z] > result
rm *.log
