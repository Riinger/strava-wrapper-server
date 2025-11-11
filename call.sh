#!/bin/bash

curl 'http://localhost:8080/api/v3/athlete/activities?page=1&after=0&perPage=2' -i -H'Accept: application/json' -o $$.tmp 

head -1 $$.tmp
# cat $$.tmp | python -mjson.tool

rm -f $$.tmp

