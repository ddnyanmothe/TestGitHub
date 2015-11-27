
with open ("addresses.txt", "r") as myfile:
    data=myfile.read().replace('\n', ' ')



import re;

m0 = re.findall(r"(\d{1,5}\s\w\s\w+\s\w+\.?\s\w+(\s\w+)?,?\s\w+\s\d{5})\s+", data);
print m0;

m1 = re.finditer(r"(\d{1,5}\s\w\s\w+\s\w+\.?\s\w+(\s\w+)?,?\s\w+\s\d{5})\s+", data);
for elem in m1:
    print 'address >>> ', elem.group()

#Another example
text = "He was carefully disguised but captured quickly by police.";
advs = re.findall(r"\w+ly", text);

print advs;

