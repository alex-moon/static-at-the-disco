#!/bin/bash
javac *.java
if (( $? != 0 )); then echo "COMPILE FAILED! BAILING!!"; fi

echo "Static at the Disco! We're going to run two experiments."
echo "See https://slides.com/formsatz/s/ for details."

echo ""
echo "1. The Circular Evaluation - hit any key when ready"
read
java Disco circle 2>&1 | head -n10

echo ""
echo "2. The Race Condition - hit any key when ready"
read
java Disco race 2>&1 | sort | uniq -c | sort -n

echo ""
echo "Thanks for playing!"
