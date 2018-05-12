#!/bin/sh

count=0

((count++))
tc="3454"
ers=YES
cmd=`echo $tc | java Solution | head -1`
printf "${count}."
./../verifyData.sh $tc $cmd $ers

((count++))
tc="10"
ers=YES
cmd=`echo $tc | java Solution | head -1`
printf "${count}."
./../verifyData.sh $tc $cmd $ers

((count++))
tc="111111"
ers=NO
cmd=`echo $tc | java Solution`
printf "${count}."
./../verifyData.sh $tc $cmd $ers

((count++))
tc="16"
ers=YES
cmd=`echo $tc | java Solution | head -1`
printf "${count}."
./../verifyData.sh $tc $cmd $ers

((count++))
tc="18"
ers=YES
cmd=`echo $tc | java Solution | head -1`
printf "${count}."
./../verifyData.sh $tc $cmd $ers

((count++))
tc="12"
ers=NO
cmd=`echo $tc | java Solution | head -1`
printf "${count}."
./../verifyData.sh $tc $cmd $ers

((count++))
tc="11"
ers=NO
cmd=`echo $tc | java Solution | head -1`
printf "${count}."
./../verifyData.sh $tc $cmd $ers

((count++))
tc="0"
ers="YES"
cmd=`echo $tc | java Solution | head -1`
printf "${count}."
./../verifyData.sh $tc $cmd $ers

((count++))
tc="1"
ers=NO
cmd=`echo $tc | java Solution`
printf "${count}."
./../verifyData.sh $tc $cmd $ers

((count++))
tc="2"
ers=NO
cmd=`echo $tc | java Solution`
printf "${count}."
./../verifyData.sh $tc $cmd $ers

((count++))
tc="3"
ers=NO
cmd=`echo $tc | java Solution`
printf "${count}."
./../verifyData.sh $tc $cmd $ers

((count++))
tc="4"
ers=NO
cmd=`echo $tc | java Solution`
printf "${count}."
./../verifyData.sh $tc $cmd $ers

((count++))
tc="5"
ers=NO
cmd=`echo $tc | java Solution`
printf "${count}."
./../verifyData.sh $tc $cmd $ers

((count++))
tc="6"
ers=NO
cmd=`echo $tc | java Solution`
printf "${count}."
./../verifyData.sh $tc $cmd $ers

((count++))
tc="7"
ers=NO
cmd=`echo $tc | java Solution`
printf "${count}."
./../verifyData.sh $tc $cmd $ers

((count++))
tc="8"
ers="YES"
cmd=`echo $tc | java Solution | head -1`
printf "${count}."
./../verifyData.sh $tc $cmd $ers

((count++))
tc="9"
ers=NO
cmd=`echo $tc | java Solution`
printf "${count}."
./../verifyData.sh $tc $cmd $ers
exit 0

