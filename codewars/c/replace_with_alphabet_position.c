//      end

#include <stdio.h>
#include <stdlib.h>
#include <string.h>


///                                 984ms
char *replace_with_alphabet_position (char *text) {
    
    int i = 0;
    int j = 0;
    int letters = strlen(text);
    char *str_alphabet = (char *)calloc(4 * strlen(text) + 1, sizeof(char));
    while (text[i] != '\0') {
     
        if (text[i] >= 'a' && text[i] <= 'z') {             //  text[i] - 96
            int num = text[i] - 96;
            if (num < 10) {
                *(str_alphabet + j++) = num + 48;
                *(str_alphabet + j++) = ' ';
            } else {
                *(str_alphabet + j++) = num / 10 + 48;
                *(str_alphabet + j++) = num % 10 + 48;
                *(str_alphabet + j++) = ' ';
            }
        }
        
        if (text[i] >= 'A' && text[i] <= 'Z') {             //  text[i] - 64
            int num = text[i] - 64;
            if (num < 10) {
                *(str_alphabet + j++) = num + 48;
                *(str_alphabet + j++) = ' ';
            } else {
                *(str_alphabet + j++) = num / 10 + 48;
                *(str_alphabet + j++) = num % 10 + 48;
                *(str_alphabet + j++) = ' ';
            }
        }
        i++;
    }
    *(str_alphabet + --j) = '\0';
    
    return str_alphabet;
}
int main () {
    
    printf("[+] text : [ %s ]\n", replace_with_alphabet_position("3675356291"));
    printf("[+] text : [ %s ]\n", replace_with_alphabet_position("343254634687923458753312"));
    
}
