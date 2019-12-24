//  more test with memory

#include <stdio.h>
#include <stdlib.h>

char *reverse_word (const char* text);

int main () {
    
    const char *input_text1 = "Y&";
    const char *input_text2 = "Y&wqemf erfn qjrwng lkerjgn erkjn geq";
    const char *input_text3 = "wef;kermfg;l ejnrg qg n;qwlkgn dm,sg agre";
    const char *input_text4 = "wqefweqfqwef wq fret &";
    const char *input_text5 = "Y1234123 5tregmwl  q.zc/as'e; &";
    const char *input_text6 = "Yqwrweqrg egt.l;ewr,g; .vs";
    const char *input_text7 = "Y&weqfqweerwt";
    const char *input_text8 = "Y";
    const char *input_text9 = "Y&3ork 43";
    const char *input_text10 = "Y&rg;ewr gm,';aefl  d''zz//23223";
    const char *input_text11 = "Y&ewrqwerwtewry gfbd";
    const char *input_text12 = "Y&qew,.d/sde';fqew'lr ";
    const char *input_text13 = "x";
    const char *input_text14 = "3|s4P-5?";
    const char *input_text15 = "Y&";
    const char *input_text16 = "Y&wqemf erfn qjrwng lkerjgn erkjn geq";
    const char *input_text17 = "wef;kermfg;l ejnrg qg n;qwlkgn dm,sg agre";
    const char *input_text18 = "wqefweqfqwef wq fret &";
    const char *input_text19 = "Y1234123 5tregmwl  q.zc/as'e; &";
    const char *input_text20 = "Yqwrweqrg egt.l;ewr,g; .vs";
    const char *input_text21 = "Y&weqfqweerwt";
    const char *input_text22 = "Y";
    const char *input_text23 = "Y&3ork 43";
    const char *input_text24 = "Y&rg;ewr gm,';aefl  d''zz//23223";
    const char *input_text25 = "Y&ewrqwerwtewry gfbd";
    const char *input_text26 = "Y&qew,.d/sde';fqew'lr ";
    const char *input_text27 = "x";
    const char *input_text28 = "3|s4P-5?";
    
    char *reverse_text;
    
    reverse_text = reverse_word(input_text1);
    reverse_text = reverse_word(input_text2);
    reverse_text = reverse_word(input_text3);
    reverse_text = reverse_word(input_text4);
    reverse_text = reverse_word(input_text5);
    reverse_text = reverse_word(input_text6);
    reverse_text = reverse_word(input_text7);
    reverse_text = reverse_word(input_text8);
    reverse_text = reverse_word(input_text9);
    reverse_text = reverse_word(input_text10);
    reverse_text = reverse_word(input_text11);
    reverse_text = reverse_word(input_text12);
    reverse_text = reverse_word(input_text13);
    reverse_text = reverse_word(input_text14);
    reverse_text = reverse_word(input_text15);
    reverse_text = reverse_word(input_text16);
    reverse_text = reverse_word(input_text17);
    reverse_text = reverse_word(input_text18);
    reverse_text = reverse_word(input_text19);
    reverse_text = reverse_word(input_text20);
    reverse_text = reverse_word(input_text21);
    reverse_text = reverse_word(input_text22);
    reverse_text = reverse_word(input_text23);
    reverse_text = reverse_word(input_text24);
    reverse_text = reverse_word(input_text25);
    reverse_text = reverse_word(input_text26);
    reverse_text = reverse_word(input_text27);
    reverse_text = reverse_word(input_text28);
    
    
    free (reverse_text);
    
}

char *reverse_word (const char *text) {
    
   // printf("[+] text : [ %s ]\n", text);
    
    int letters = 0;
    int letters_in_word = 0;
    
    for (int i = 0; *(text + i) != '\0'; i++)
        letters++;
    
  //  printf("[+] there are : [ %d ]  letters\n", letters);
    
    char *working_text = (char *) malloc(letters * 8192);
    int wtcnt = 0;
   // printf("[+] &working_text : [ %p ]\n", &working_text);
   // printf("[+] *working_text : [ %p ]\n", working_text);
    
    for (int i = 0; i < letters + 1; i++) {
        if (text[i] == ' ' || text[i] == '\0') {
            
            char *word = (char *)malloc(letters_in_word);
            
  //          printf("[+] i : [ %d ]\t letters in word : [ %d ]\n", i, letters_in_word);
            for (int j = letters_in_word - 1 + i - letters_in_word, k = 0; j >= 0; j--, k++)
                *(word + k) = text[j];
            
    //        printf("[+] reverse word : [ %s ]\n", word);
            
            for (int j = 0; j < letters_in_word; j++)
                working_text[wtcnt++] = word[j];
             
            
            
            if (text[i] != '\0')
                working_text[wtcnt++] = ' ';
            
      //      printf("[+] working_text : [ %s ]\n", working_text);
            
            letters_in_word = 0;
           
           free(word);
        } else  letters_in_word++;
    }

    printf("\n[+] %s\n", text);
    printf("[+] %s\n", working_text);
    
    return working_text;
    
}


