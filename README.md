# Polar_Security_test
a Test in automation

Hi,
This assignment is the one requested as a home test for automation self learning ability.
This assignment was written in Eclipse IDE using selenium, and therfore requires having all selenium java jars add-ons pre running the code, and most probably will function best by using this IDE.

I used GoogleChrome as the webDriver.
Attached to this code we have the "hA_vars.json" file which contains 3 criteria variables, and respectively 3 id tag values, 1 sort By criteria value and Sort order value.
All of these can be edited by the user in the json file in order to change the filtering of the results. The code will read from the JSON file and import the criteria's values and use them to filter the requested results.
It is important to mention - the value of each criteria should be the html id/xpath tag of the desired criteria. value can be plain text, as long as it appears in the criteria's selction options.

Once running the code, a chrome browser should open, on FINVIZ website.
It should select the "Screener" tab, and inside select "all" tabs.
After that, it should filter the results by the criteria and values enter in the JSON file.

Finally, it should print out in the console the top 10 stocks' company names.

Execution should be standart, by running the program through the IDE.
