"""
    @author : Praveen Patil

    To run the below program, please use the following command.

    python3 SpryHealthSkillsTestQuestion2.py <Your InputFileName>
    eg:  python3 SpryHealthSkillsTestQuestion2.py input.txt

"""

import re
import sys
import collections

wordCount = {}
def spry_count_words_in_quotations(file_path: str):
    lst = []
    print("Your Input File : " + file_path)
    print("\n")
    with open(filepath, "r") as fd:
        for line in fd:
            lst.append(line.strip())
    data = "".join(lst);
    matches = re.findall(r'\"(.+?)\"', data)
    for word in matches:
        output = word.split(" ");
        for w in output:
            w = " ".join(re.findall("^[A-Za-z'-]+", w))
            wordCount[w.lower()] = wordCount.get(w.lower(),0)+1
    if '' in wordCount.keys():
        del wordCount['']
    sortedOutput = sorted(wordCount.items(), key=lambda val: val[1])
    result = collections.OrderedDict(sortedOutput)
    for ans in sorted(result, key=result.get, reverse=True):
        print(ans+" -> "+str(result[ans]))

def main(filepath):
    spry_count_words_in_quotations(filepath)

if __name__ == '__main__':
    filepath = sys.argv[1]
    main(filepath)