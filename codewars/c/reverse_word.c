#include <stdio.h>
#include <stdlib.h>

char *reverse_word (const char* text);

int main () {
    
    const char *input_text = "nuPl4T73";
    char *reverse_text;
    
    reverse_text = reverse_word(input_text);
    
    free (reverse_text);
    
}

char *reverse_word (const char *text) {
    
    printf("[+] text : [ %s ]\n", text);
    
    int letters = 0;
    int letters_in_word = 0;
    
    for (int i = 0; *(text + i) != '\0'; i++)
        letters++;
    
    printf("[+] there are : [ %d ]  letters\n", letters);
    
    char *working_text = (char *) malloc(letters + 1);
    int wtcnt = 0;
    printf("[+] &working_text : [ %p ]\n", &working_text);
    printf("[+] *working_text : [ %p ]\n", working_text);
    
    for (int i = 0; i < letters + 1; i++) {
        if (text[i] == ' ' || text[i] == '\0') {
            
            char *word = (char *)malloc(letters_in_word + 1);
            
            printf("[+] i : [ %d ]\t letters in word : [ %d ]\n", i, letters_in_word);
            for (int j = letters_in_word - 1 + i - letters_in_word, k = 0; j >= 0; j--, k++)
                *(word + k) = text[j];
            
            printf("[+] reverse word : [ %s ]\n", word);
            
            for (int j = 0; j < letters_in_word; j++)
                working_text[wtcnt++] = word[j];
            
            if (text[i] != '\0')
                working_text[wtcnt++] = ' ';
            
            free(word);
            
            printf("[+] working_text : [ %s ]\n", working_text);
            
            letters_in_word = 0;
           
            
        } else  letters_in_word++;
    }

    printf("[+] start text\n\t %s\n", text);
    printf("[+] reverse text\n\t %s\n", working_text);
    
    return working_text;
    
}


