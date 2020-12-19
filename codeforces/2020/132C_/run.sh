#!/bin/bash

rm *.log
echo $1 >> in.log
echo $2 >> in.log
RESULT=`java Solution < in.log`

if [ $RESULT -ne $3 ]; then
	echo NOK
else
	echo OK $RESULT
fi

