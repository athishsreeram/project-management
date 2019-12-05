file=$PWD"/javacore.txt"
count=1

while IFS= read line
do
    IFS=' '
    read -ra ADDR <<< "$line"
    if [ $count -eq 1 ]
       then
            ARNAME[1]="Cause:  ${ADDR[1]}"
        fi
    if [ $count -eq 2 ]
       then
            ARNAME[0]="${ADDR[1]}"
    fi
    if [ $count -eq 3 ]
       then
            IFS='='
            read -ra ADDR3 <<< "${ADDR[1]}"

            ARNAME[2]="Environment: ${ADDR3[1]}"
    fi
    if [ $count -eq 4 ]
       then
            IFS='='
            read -ra ADDR4 <<< "${ADDR[1]}"

             ARNAME[3]="Port: ${ADDR4[1]}"
    fi
        let count=count+1

done <"$file"

printf "%s\n" "${ARNAME[@]}" > Output.txt