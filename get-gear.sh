#!/bin/bash

if [ "$2" != "" ] ; then
	curl -s 'http://localhost:8080/api/v3/gear/'$1 -H'Accept: application/json' -w 'STATUS = %{http_code}\n\n' -H"CORRID: $2" -o $$.tmp 
else
	curl -s 'http://localhost:8080/api/v3/gear/'$1 -H'Accept: application/json' -w 'STATUS = %{http_code}\n\n' -o $$.tmp 
fi

cat $$.tmp | python -mjson.tool 

rm -f $$.tmp

