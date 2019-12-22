#include <stdio.h>
#include <stdlib.h>

char *reverse_word (char* text);

int main () {
    
    char *input_text = "some text";
    char *reverse_text;
    
    reverse_text = reverse_word(input_text);
    
    printf("[+] start text\n\t %s\n", input_text);
    printf("[+] reverse text\n\t %s\n", reverse_text);
    
    
}

char *reverse_word (char *text) {
    
    int letter_count = 0;
    
    for (int i = 0; text[i] != '\0'; i++)
        letter_count++;
    
    char reverse_array[letter_count];
    
    for (int i = letter_count - 1, j = 0; i > 0; i--, j++)
        reverse_array[j] = text[i];
    
    int word_count = 0;
    
    for (int i = 0; i < letter_count; i++)
        if (reverse_array[i] == ' ')
            word_count++;

    char *slit_array[word_count];
    
    
    //          end here
    for (int i = word_count; j = 0, k = 0; j < letter_count; j++, k++)
        if (reverse_array[j] == ' ') {
            
            i++;
        }
    
    

    return text;
}


