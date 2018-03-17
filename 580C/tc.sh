#!/bin/sh

count=0

((count++))
tc=tc1
ers=2
cmd=`java Solution < tc1`
printf "${count}."
./../verifyData.sh $tc $cmd $ers

((count++))
tc=tc2
ers=2
cmd=`java Solution < tc2`
printf "${count}."
./../verifyData.sh $tc $cmd $ers
