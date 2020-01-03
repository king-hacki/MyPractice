#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *reverse_inside_parentheses (char *text) {
    
    typedef enum {false, true} bool;
    
    typedef struct node {
        char *text;
        bool is_use;
        struct node *parent;
        struct node **childrens;
    } node;
    
    int nodes_count = 0;
    
    for (int i = 0; text[i] != '\0'; i++)
        if (text[i] == '(')
            nodes_count++;
    
    node root;
    root.text = (char *) calloc(strlen(text), sizeof(char));
    root.parent = NULL;
    root.childrens = (node **) calloc(nodes_count, sizeof(node));
    
    node *par = &root;

    //      test next cicle
    for (int i = 0; text[i] == '\0'; i++) {
        
        if (text[i] == '(') {
            
            node new_node;
            
            new_node.text = (char *) calloc(strlen(text), sizeof(char));
            new_node.childrens = (node **) calloc(nodes_count, sizeof(node));
            new_node.parent = par;
            
            int j = 0;
            while (1)
                if (par->childrens[j] == NULL) {
                    par->childrens[j] = &new_node;
                    par = par->childrens[j];
                    break;
                } else
                    j++;
    
        }
        
        if (text[i] == ')')
            par = par->parent;
        
    }
    
    return text;
}

int main () {
    
    printf("[+] text : %s\n", reverse_inside_parentheses("some (text to (test)) in this pro(gra)m"));
    
}
