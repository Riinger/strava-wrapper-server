#!/bin/bash

GFILE=$1

function get_field() {
	sed -n "/\"$1\"/{
		s/.*\": \"//
		s/\".*//
		p
	}" $GFILE
}

# printf "%s|%s|%s\n" "$(get_field id)" "$(get_field name)" "$(get_field description)"

printf "    %s: \n" "$(get_field id)"
printf "      name: %s\n" "$(get_field name)"
printf "      description: %s\n" "$(get_field description)"
