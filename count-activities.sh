#!/bin/bash

for ARC in $* ; do
	printf "%-32s " $(basename $ARC)
	cat $ARC | python -mjson.tool | grep -c start_date_local
done
