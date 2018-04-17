#!/bin/bash

User=$1

cp ${User}.userlist tmp

curl https://leetcode.com/${User}/ > tmp1

grep problems tmp1 | tr -d " " | cut -c10- | tr -d "\"" | sort | uniq > tmp2

Original=`wc tmp | awk -F' ' '{print $1}'`
NewFile=`wc tmp2 | awk -F' ' '{print $1}'`

echo "All problems: ${Original}"
echo "New problems: ${NewFile}"

diff tmp tmp2 | grep "<"

rm -f tmp tmp1 tmp2

exit 0
