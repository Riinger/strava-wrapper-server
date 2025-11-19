#!/bin/bash

ACTION=${1:-none}

curl -s -w 'STATUS = %{http_code}\n\n'  \
	-H'Accept: application/json' \
	-H"correlation-id: ${2:-DUMMY}" -o $$.tmp \
'http://localhost:8080/api/v3/athlete/activities?before=1754524800&after=1754179200&page=1&per_page=23'

cat $$.tmp | python -mjson.tool 

rm -f $$.tmp

