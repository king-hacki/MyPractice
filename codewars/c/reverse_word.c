//  end

#include <stdio.h>
#include <stdlib.h>

#define TRUE 1

char *reverse_word (const char* text);

int main () {
    
    const char *input_text0 = "some text to test";
    char *reverse_text;
    reverse_text = reverse_word(input_text0);
}

///                     923ms

char *reverse_word (const char *text) {

	printf("\n[+] text : [ %s ]\n", text);
    
    int tc = 0;
    int letters = 0;
    for (int i = 0; *(text + i) != '\0'; i++)
        letters++;
    printf("[+] letters : [ %d ]\n", letters);
    
    char *working_text = (char *) malloc(letters + 1);
    int wc = 0;

    while (1) {
    
        if (*text == ' ' || *text == '\0') {
        
            int counter = 0;
            while (tc > 0) {
                *(working_text + wc++) = *(--text);
                tc--;
                counter++;
            }
            
            if (wc == letters) {
                *(working_text + wc) = '\0';
                break;
            }
            
            *(working_text + wc++) = ' ';
            counter++;
            text = text + counter;
            
        } else {
        
            tc++;
            text++;
            
        }
        
    }
    
    printf("[+] reverse_text : [ %s ]\n\n", working_text);
    return working_text;
}


