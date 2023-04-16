# DHL Label Converter

This command line tool converts pdf labels from the offical website to a 62mm x 180mm png version that can be printed on smaller label printers such as the Brother QL-700.

## Usage:

Create an executable .jar file with maven 

`mvn assembly:single`

Execute the .jar file with 

`java -jar [filename.jar] -path /../dhllabel.pdf (-type)`

## Options

The tool has two options:
`-p, -path` the path to the file you want to convert
`-t, -type` the type of the input file

The two supported types are `a` national label (for Germany) and `b` labels for international shippping. The default is `a`. 
