#!/bin/bash

FILENAME=$1
(java Solution < $FILENAME && grep ">" $FILENAME | sed 's/--> //g') | uniq
