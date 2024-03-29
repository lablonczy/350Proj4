/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <iostream>
#include <vector>

using namespace std;

string vecToString(vector<char> chars);
vector<char> stringToVec(string word);
vector<char> palindrome(vector<char> current, int lowerBound);
vector<char> subString(vector<char> chars, int lowerBound, int upperBound);


int main()
{
    string word = "" ;
    while((cin >> word)){
        string palindromeString = vecToString(palindrome(stringToVec(word), 0));
        cout << palindromeString.size() << " " << palindromeString << endl;
    }
}

string vecToString(vector<char> chars) {
    string output;

    for(char &c : chars)
        output += c;

    return output;
}

vector<char> stringToVec(string word) {
    return vector<char>(word.begin(), word.end());
}

vector<char> palindrome(vector<char> current, int lowerBound) {
    int upperBound = (current.size()-1) - lowerBound;
    vector<char> substring = subString(current, lowerBound, upperBound);

    if(substring.size() == 0)
        return current;

    char first = substring[0], last = substring[substring.size() - 1];
    if(toupper(first) != toupper(last)) {
        vector<char> firstOption = current;
        firstOption.insert(firstOption.begin() + lowerBound, toupper(last));
        firstOption = palindrome(firstOption, lowerBound+1);

        vector<char> secOption = current;
        secOption.insert(secOption.begin() + upperBound+1, toupper(first));
        secOption = palindrome(secOption, lowerBound+1);

        if(firstOption.size() <= secOption.size())
            return firstOption;
        else
            return secOption;

    } else {
        return palindrome(current, lowerBound+1);
    }
}

vector<char> subString(vector<char> chars, int lowerBound, int upperBound) {
    if(lowerBound >= upperBound)
        return vector<char> {};

    vector<char> subVec;
    for(int i=lowerBound;i<=upperBound;i++)
        subVec.push_back(chars[i]);

    return subVec;
}


















