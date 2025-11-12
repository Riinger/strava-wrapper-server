#!/bin/bash

curl -s 'http://localhost:8080/api/v3/athlete/activities' -H'Accept: application/json' -w 'STATUS = %{http_code}\n\n'  -H"CORRID: $1" -o $$.tmp 
cat $$.tmp | python -mjson.tool 
rm -f $$.tmp
exit

if [ "$1" != "" ] ; then
	curl -s 'http://localhost:8080/api/v3/athlete/activities/all?update_cache=false' -H'Accept: application/json' -w 'STATUS = %{http_code}\n\n'  -H"CORRID: $1" -o $$.tmp 
else
	curl -s 'http://localhost:8080/api/v3/athlete/activities/all?update_cache=false&update_cache=false' -H'Accept: application/json' -w 'STATUS = %{http_code}\n\n' -o $$.tmp 
fi

cat $$.tmp | python -mjson.tool 

rm -f $$.tmp

