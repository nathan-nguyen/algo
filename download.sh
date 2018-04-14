#!/bin/bash

User=$1

curl https://leetcode.com/${User}/ >> tmp
cat ${User}.userlist >> tmp

grep problems tmp | tr -d " " | cut -c10- | tr -d "\"" | sort | uniq > ${User}.userlist

# Remove tmp file
rm -f tmp

