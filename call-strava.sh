#!/bin/bash

# Call Strava directly

PP=${1:-30}

curl  \
	-H "accept:application/json" \
	-H "Authorization:Bearer f9e807b8bde010c8b7f356a926fd1cbbe8d6eafc" \
	-o $$.tmp \
'https://www.strava.com/api/v3/athlete/activities?after=1756684800&page=1&per_page='$PP
# 'https://www.strava.com/api/v3/athlete/activities?after=1763078400&page=1&per_page='$PP


printf "%s activities\n" $(cat $$.tmp | python -mjson.tool | grep -c start_date_local)

rm $$.tmp
