#!/bin/bash

User=$1

curl https://leetcode.com/${User}/ > tmp1

grep problems tmp1 | tr -d " " | cut -c10- | tr -d "\"" > tmp2
cat ${User}.userlist tmp2 | sort | uniq > tmp1

mv tmp1 ${User}.userlist

# Remove tmp file
rm -f tmp1 tmp2

