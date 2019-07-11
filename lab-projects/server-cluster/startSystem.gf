
start locator --name=locator 

configure pdx --read-serialized=true

start server --server-port=0  --locators=localhost[10334] --name=server1 --cache-xml-file=/Users/balakaza/gemfire/gemfire-developer-labfiles/lab-projects/server-cluster/xml/serverCache.xml
start server --server-port=0  --locators=localhost[10334] --name=server2 --cache-xml-file=/Users/balakaza/gemfire/gemfire-developer-labfiles/lab-projects/server-cluster/xml/serverCache.xml
start server --server-port=0  --locators=localhost[10334] --name=server3 --cache-xml-file=/Users/balakaza/gemfire/gemfire-developer-labfiles/lab-projects/server-cluster/xml/serverCache.xml
