#!/bin/bash

if [ "$1" != "" ] ; then
	curl -s 'http://localhost:8080/api/v3/athlete/activities/all?updateCache=false' -H'Accept: application/json' -w 'STATUS = %{http_code}\n\n'  -H"correlation-id: $1" -o $$.tmp 
else
	curl -s 'http://localhost:8080/api/v3/athlete/activities/all?updateCache=false&update_cache=false' -H'Accept: application/json' -w 'STATUS = %{http_code}\n\n' -o $$.tmp 
fi

cat $$.tmp | python -mjson.tool 

rm -f $$.tmp

