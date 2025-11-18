#!/bin/bash

C=${1:-DUMMY}

curl -X POST 'http://localhost:8080/api/v3/admin/cache/archive?perPage=100' -i -H'Accept: application/json' -H "correlation-id: $C" -o $$.tmp 

head -1 $$.tmp
# cat $$.tmp | python -mjson.tool

rm -f $$.tmp

