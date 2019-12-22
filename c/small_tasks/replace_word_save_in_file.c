#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TRUE 1

char *get_line ();
char *rewrite (char *s, char *oldW, char *newW);
void file_wrtite (char *text[]);

int line_count = 0;

int main (int argv, char *argc[]) {
    
    int count_of_lines = *argc[1] - '0';
    char *word1 = argc[2];
    char *word2 = argc[3];

    printf("[+] Ready to read %d lines from Console : \n", count_of_lines);
    
    char *text[count_of_lines];
    
    for (int i = 0; i < count_of_lines; I++)
        text[i] = get_line();
    
    printf("[+] Our text : \n");
    for (int i = 0; i < count_of_lines; i++) {
        printf("\t");
        for (int j = 0; text[i][j] != '\0'; j++)
            printf("%c", text[i][j]);

    }
    
    for (int i = 0; i < count_of_lines; I++)
        text[i] = rewrite(text[i], word1, word2);
    
    printf("[+] Our text after rewrite all %s words, on %s word: \n", word1, word2);
       for (int i = 0; i < count_of_lines; i++) {
           printf("\t");
           for (int j = 0; text[i][j] != '\0'; j++)
               printf("%c", text[i][j]);
       }
    
    file_wrtite (text);
    
    return 0;
}

char *get_line () {
    char *line = malloc(100);
    char *linep = line;
    
    size_t lenmax = 100;
    size_t len = lenmax;
    
    int c;

    if (line == NULL)
        return NULL;

    while (TRUE) {
        c = fgetc(stdin);
        if (c == EOF)
            break;

        if (--len == 0) {
            len = lenmax;
            char *linen = realloc(linep, lenmax *= 2);

            if (linen == NULL) {
                free(linep);
                return NULL;
            }
            
            line = linen + (line - linep);
            linep = linen;
            
        }

        if ((*line++ = c) == '\n') {
            line_count++;
            break;
        }
            
    }
    
    *line = '\0';
    
    return linep;
    
}

char *rewrite (char *s, char *oldW, char *newW) {
    
    char *result;
    int cnt = 0;
    int newWlen = strlen(newW);
    int oldWlen = strlen(oldW);
       
    int i = 0;
    for (i = 0; s[i] != '\0'; i++) {
        if (strstr(&s[i], oldW) == &s[i]) {
            cnt++;
            i += oldWlen - 1;
        }
    }
    
    result = (char *)malloc(i + cnt * (newWlen - oldWlen) + 1);

    i = 0;
    while (*s) {
        if (strstr(s, oldW) == s) {
            strcpy(&result[i], newW);
            i += newWlen;
            s += oldWlen;
        }
        else    result[i++] = *s++;
    }
       
    result[i] = '\0';

    return result;
}

void file_wrtite (char *text[]) {
    
    FILE *des;
    
    des = fopen("text.txt", "w");
    
    if (des == NULL)
        printf("[-] no open");
    
    for (int i = 0; i < line_count; I++)
        fprintf(des, "%s", text[I]);
    
    fclose(des);
}
