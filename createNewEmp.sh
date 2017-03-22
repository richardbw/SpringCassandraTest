#!/bin/bash
#
#  auth: rbw
#  date: 20170322
#  desc: 
#
#- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
BASE_DIR=`cd "${0%/*}/." && pwd`

ENDPOINT='http://localhost:8080/newEmp'

PAYLOAD=$(cat <<EOT
{
    "email": "raskolnikov@gmail.com",
    "name": "Simon Kleinsmith"
}
EOT
)

echo $PAYLOAD | \
    curl -X "PUT"                       \
    -H "Accept: application/json"       \
    -H 'Content-Type: application/json' \
    -d @- $ENDPOINT                     \
        | python -m json.tool


#- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
#//EOF
