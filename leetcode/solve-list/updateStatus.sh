#!/bin/bash

User=$1

wc ${User}.userlist && ./download.sh $User && wc ${User}.userlist

