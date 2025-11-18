#!/bin/bash

curl -X POST 'http://localhost:8080/api/v3/admin/cache/archive?perPage=20' -i -H'Accept: application/json' -o $$.tmp 

head -1 $$.tmp
# cat $$.tmp | python -mjson.tool

rm -f $$.tmp

