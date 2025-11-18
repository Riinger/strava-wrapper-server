#!/bin/bash

# curl -s 'http://localhost:8080/api/v3/athlete/activities?before=1754191900&after=1754194500' -H'Accept: application/json' -w 'STATUS = %{http_code}\n\n'  -H"correlation-id: $1" -o $$.tmp  >$$.out
curl -s 'http://localhost:8080/api/v3/athlete/activities' -H'Accept: application/json' -w 'STATUS = %{http_code}\n\n'  -H"correlation-id: $1" -o $$.tmp  >$$.out
STATUS=$(grep STATUS $$.out | sed -e "s/.* = //")
if [[ $STATUS =~ ^2 ]] ; then
	echo SUCCESS $STATUS
	echo
	cat $$.tmp | python -mjson.tool 
else
	echo FAILURE $STATUS
	echo
#	cat $$.tmp
	cat $$.tmp | python -mjson.tool 
fi
rm -f $$.tmp $$.out
exit

if [ "$1" != "" ] ; then
	curl -s 'http://localhost:8080/api/v3/athlete/activities/all?update_cache=false' -H'Accept: application/json' -w 'STATUS = %{http_code}\n\n'  -H"correlation-id: $1" -o $$.tmp 
else
	curl -s 'http://localhost:8080/api/v3/athlete/activities/all?update_cache=false&update_cache=false' -H'Accept: application/json' -w 'STATUS = %{http_code}\n\n' -o $$.tmp 
fi

cat $$.tmp | python -mjson.tool 

rm -f $$.tmp

