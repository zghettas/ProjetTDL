for ((idx=0;${idx}<=9;idx++)) do
  cp tests/test0${idx}.bloc resultats/test0${idx}.results
   echo "======================" >> resultats/test0${idx}.results
   echo "======================" >> resultats/test0${idx}.results
   echo "======================" >> resultats/test0${idx}.results
  (/usr/bin/java -classpath ./eggc-5.4.3.jar:. Main tests/test0${idx}.bloc >> resultats/test0${idx}.results 2>&1)
done

for ((idx=10;${idx}<=99;idx++)) do
  cp tests/test${idx}.bloc resultats/test${idx}.results
  echo "======================"  >> resultats/test${idx}.results
  echo "======================"  >> resultats/test${idx}.results
  echo "======================"  >> resultats/test${idx}.results
  (/usr/bin/java -classpath ./eggc-5.4.3.jar:. Main tests/test${idx}.bloc >> resultats/test${idx}.results 2>&1)
done

for ((idx=100;${idx}<=103;idx++)) do
  cp tests/test${idx}.bloc resultats/test${idx}.results
  echo "======================"  >> resultats/test${idx}.results
  echo "======================"  >> resultats/test${idx}.results
  echo "======================"  >> resultats/test${idx}.results
  (/usr/bin/java -classpath ./eggc-5.4.3.jar:. Main tests/test${idx}.bloc >> resultats/test${idx}.results 2>&1)
done
