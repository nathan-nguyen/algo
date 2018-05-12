#!/bin/bash

User=`echo $1 | sed 's/.userlist//'`
User2=`echo $2 | sed 's/.userlist//'`

./updateStatus.sh $User
./updateStatus.sh $User2

cp ${User}.userlist tmp

curl https://leetcode.com/${User}/ > tmp1

grep problems tmp1 | tr -d " " | cut -c10- | tr -d "\"" | sort | uniq > tmp2

Original=`wc tmp | awk -F' ' '{print $1}'`
NewFile=`wc tmp2 | awk -F' ' '{print $1}'`

echo "All problems: ${Original}"
echo "New problems: ${NewFile}"

diff tmp tmp2 | grep "<" | cut -c3- > tmp1

diff tmp1 ${User2}.userlist | grep "<" | cut -c3-

rm -f tmp tmp1 tmp2

exit 0

